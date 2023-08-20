package com.vicmatskiv.weaponlib.grenade;

import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import com.vicmatskiv.weaponlib.animation.*;
import net.minecraft.client.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.model.*;
import java.util.function.*;
import org.apache.logging.log4j.*;
import com.vicmatskiv.weaponlib.*;
import java.util.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import java.util.stream.*;

public class GrenadeRenderer extends CompatibleGrenadeRenderer
{
    private static final Logger logger;
    private static final float DEFAULT_RANDOMIZING_RATE = 0.33f;
    private static final float DEFAULT_NORMAL_RANDOMIZING_AMPLITUDE = 0.06f;
    private static final int DEFAULT_ANIMATION_DURATION = 70;
    private Builder builder;
    private Map<StateManagerKey, MultipartRenderStateManager<RenderableState, Part, RenderContext<RenderableState>>> firstPersonStateManagers;
    private MultipartTransitionProvider<RenderableState, Part, RenderContext<RenderableState>> weaponTransitionProvider;
    protected ClientModContext clientModContext;
    
    private GrenadeRenderer(final Builder builder) {
        super(builder);
        this.builder = builder;
        this.firstPersonStateManagers = new HashMap<StateManagerKey, MultipartRenderStateManager<RenderableState, Part, RenderContext<RenderableState>>>();
        this.weaponTransitionProvider = new WeaponPositionProvider(this);
    }
    
    protected long getTotalTakingSafetyPinOffDuration() {
        return this.builder.totalTakingPinOffDuration;
    }
    
    protected long getTotalThrowingDuration() {
        return this.builder.totalThrowingDuration;
    }
    
    @Override
    protected ClientModContext getClientModContext() {
        return this.clientModContext;
    }
    
    public void setClientModContext(final ClientModContext clientModContext) {
        this.clientModContext = clientModContext;
    }
    
    @Override
    protected StateDescriptor getStateDescriptor(final EntityPlayer player, final ItemStack itemStack) {
        final float amplitude = this.builder.normalRandomizingAmplitude;
        final float rate = this.builder.normalRandomizingRate;
        RenderableState currentState = null;
        final PlayerItemInstance<?> playerItemInstance = this.clientModContext.getPlayerItemInstanceRegistry().getItemInstance(player, itemStack);
        PlayerGrenadeInstance playerGrenadeInstance = null;
        if (playerItemInstance == null || !(playerItemInstance instanceof PlayerGrenadeInstance) || playerItemInstance.getItem() != itemStack.getItem()) {
            GrenadeRenderer.logger.error("Invalid or mismatching item. Player item instance: {}. Item stack: {}", new Object[] { playerItemInstance, itemStack });
        }
        else {
            playerGrenadeInstance = (PlayerGrenadeInstance)playerItemInstance;
        }
        if (playerGrenadeInstance != null) {
            final AsyncGrenadeState asyncWeaponState = this.getNextNonExpiredState(playerGrenadeInstance);
            switch (asyncWeaponState.getState()) {
                case SAFETY_PING_OFF: {
                    currentState = RenderableState.SAFETY_PIN_OFF;
                    break;
                }
                case STRIKER_LEVER_RELEASED: {
                    currentState = RenderableState.STRIKER_LEVEL_OFF;
                    break;
                }
                case THROWING: {
                    currentState = RenderableState.THROWING;
                    break;
                }
                case THROWN: {
                    currentState = RenderableState.THROWN;
                    break;
                }
                default: {
                    if (player.isSprinting() && this.builder.firstPersonPositioningRunning != null) {
                        currentState = RenderableState.RUNNING;
                        break;
                    }
                    break;
                }
            }
            GrenadeRenderer.logger.trace("Rendering state {} created from {}", new Object[] { currentState, asyncWeaponState.getState() });
        }
        if (currentState == null) {
            currentState = RenderableState.NORMAL;
        }
        final StateManagerKey key = new StateManagerKey(player, (playerGrenadeInstance != null) ? playerGrenadeInstance.getItemInventoryIndex() : -1);
        MultipartRenderStateManager<RenderableState, Part, RenderContext<RenderableState>> stateManager = this.firstPersonStateManagers.get(key);
        if (stateManager == null) {
            stateManager = new MultipartRenderStateManager<RenderableState, Part, RenderContext<RenderableState>>(currentState, this.weaponTransitionProvider, Part.MAIN_ITEM);
            this.firstPersonStateManagers.put(key, stateManager);
        }
        else {
            stateManager.setState(currentState, true, currentState == RenderableState.THROWING);
        }
        return new StateDescriptor(playerGrenadeInstance, stateManager, rate, amplitude);
    }
    
    private AsyncGrenadeState getNextNonExpiredState(final PlayerGrenadeInstance playerWeaponState) {
        AsyncGrenadeState asyncWeaponState = null;
        while ((asyncWeaponState = playerWeaponState.nextHistoryState()) != null && System.currentTimeMillis() > asyncWeaponState.getTimestamp() + asyncWeaponState.getDuration()) {}
        return asyncWeaponState;
    }
    
    private Consumer<RenderContext<RenderableState>> createWeaponPartPositionFunction(final Transition<RenderContext<RenderableState>> t) {
        if (t == null) {
            return context -> {};
        }
        final Consumer<RenderContext<RenderableState>> weaponPositionFunction = t.getItemPositioning();
        if (weaponPositionFunction == Transition.anchoredPosition()) {
            return MultipartTransition.anchoredPosition();
        }
        if (weaponPositionFunction != null) {
            return context -> consumer.accept(context);
        }
        return context -> {};
    }
    
    private Consumer<RenderContext<RenderableState>> createWeaponPartPositionFunction(final Consumer<RenderContext<RenderableState>> weaponPositionFunction) {
        if (weaponPositionFunction == Transition.anchoredPosition()) {
            return MultipartTransition.anchoredPosition();
        }
        if (weaponPositionFunction != null) {
            return context -> consumer.accept(context);
        }
        return context -> {};
    }
    
    private List<MultipartTransition<Part, RenderContext<RenderableState>>> getComplexTransition(final List<Transition<RenderContext<RenderableState>>> wt, final List<Transition<RenderContext<RenderableState>>> lht, final List<Transition<RenderContext<RenderableState>>> rht, final LinkedHashMap<Part, List<Transition<RenderContext<RenderableState>>>> custom) {
        final List<MultipartTransition<Part, RenderContext<RenderableState>>> result = new ArrayList<MultipartTransition<Part, RenderContext<RenderableState>>>();
        for (int i = 0; i < wt.size(); ++i) {
            final Transition<RenderContext<RenderableState>> p = wt.get(i);
            final Transition<RenderContext<RenderableState>> l = lht.get(i);
            final Transition<RenderContext<RenderableState>> r = rht.get(i);
            long pause = p.getPause();
            if (DebugPositioner.isDebugModeEnabled()) {
                final DebugPositioner.TransitionConfiguration transitionConfiguration = DebugPositioner.getTransitionConfiguration(i, false);
                if (transitionConfiguration != null) {
                    pause = transitionConfiguration.getPause();
                }
            }
            final MultipartTransition<Part, RenderContext<RenderableState>> t = new MultipartTransition<Part, RenderContext<RenderableState>>(p.getDuration(), pause).withPartPositionFunction(Part.MAIN_ITEM, p.getAttachedTo(), this.createWeaponPartPositionFunction(p)).withPartPositionFunction(Part.LEFT_HAND, l.getAttachedTo(), this.createWeaponPartPositionFunction(l)).withPartPositionFunction(Part.RIGHT_HAND, r.getAttachedTo(), this.createWeaponPartPositionFunction(r));
            for (final Map.Entry<Part, List<Transition<RenderContext<RenderableState>>>> e : custom.entrySet()) {
                final List<Transition<RenderContext<RenderableState>>> partTransitions = e.getValue();
                Transition<RenderContext<RenderableState>> partTransition = null;
                if (partTransitions != null && partTransitions.size() > i) {
                    partTransition = partTransitions.get(i);
                }
                else {
                    GrenadeRenderer.logger.warn("Transition not defined for part {}", new Object[] { custom });
                }
                t.withPartPositionFunction(e.getKey(), partTransition.getAttachedTo(), this.createWeaponPartPositionFunction(partTransition));
            }
            result.add(t);
        }
        return result;
    }
    
    private List<MultipartTransition<Part, RenderContext<RenderableState>>> getSimpleTransition(final Consumer<RenderContext<RenderableState>> w, final Consumer<RenderContext<RenderableState>> lh, final Consumer<RenderContext<RenderableState>> rh, final LinkedHashMap<Part, SimplePositioning> custom, final int duration) {
        long pause = 0L;
        if (DebugPositioner.isDebugModeEnabled()) {
            final DebugPositioner.TransitionConfiguration transitionConfiguration = DebugPositioner.getTransitionConfiguration(0, false);
            if (transitionConfiguration != null) {
                pause = transitionConfiguration.getPause();
            }
        }
        final MultipartTransition<Part, RenderContext<RenderableState>> mt = new MultipartTransition<Part, RenderContext<RenderableState>>(duration, pause).withPartPositionFunction(Part.MAIN_ITEM, null, this.createWeaponPartPositionFunction(w)).withPartPositionFunction(Part.LEFT_HAND, null, this.createWeaponPartPositionFunction(lh)).withPartPositionFunction(Part.RIGHT_HAND, null, this.createWeaponPartPositionFunction(rh));
        custom.forEach((part, position) -> multipartTransition.withPartPositionFunction(part, position.attachedTo, this.createWeaponPartPositionFunction(position.positioning)));
        return Collections.singletonList(mt);
    }
    
    public void renderItem(final ItemStack weaponItemStack, final RenderContext<RenderableState> renderContext, final MultipartPositioning.Positioner<Part, RenderContext<RenderableState>> positioner) {
        if (this.builder.getTextureName() != null) {
            Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(this.builder.getModId() + ":textures/models/" + this.builder.getTextureName()));
        }
        else {
            String textureName = null;
            if (textureName == null) {
                final ItemGrenade weapon = (ItemGrenade)weaponItemStack.getItem();
                textureName = weapon.getTextureName();
            }
            Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(this.builder.getModId() + ":textures/models/" + textureName));
        }
        this.builder.getModel().render((Entity)null, renderContext.getLimbSwing(), renderContext.getFlimbSwingAmount(), renderContext.getAgeInTicks(), renderContext.getNetHeadYaw(), renderContext.getHeadPitch(), renderContext.getScale());
        final PlayerItemInstance<?> itemInstance = renderContext.getPlayerItemInstance();
        if (!(itemInstance instanceof PlayerGrenadeInstance)) {
            return;
        }
        final PlayerGrenadeInstance grenadeInstance = (PlayerGrenadeInstance)itemInstance;
        final List<CompatibleAttachment<? extends AttachmentContainer>> attachments = grenadeInstance.getActiveAttachments(renderContext, true);
        this.renderAttachments(positioner, renderContext, attachments);
    }
    
    @Override
    public void renderAttachments(final MultipartPositioning.Positioner<Part, RenderContext<RenderableState>> positioner, final RenderContext<RenderableState> renderContext, final List<CompatibleAttachment<? extends AttachmentContainer>> attachments) {
        for (final CompatibleAttachment<?> compatibleAttachment : attachments) {
            if (compatibleAttachment != null && !(compatibleAttachment.getAttachment() instanceof ItemSkin)) {
                this.renderCompatibleAttachment(compatibleAttachment, positioner, renderContext);
            }
        }
    }
    
    private void renderCompatibleAttachment(final CompatibleAttachment<?> compatibleAttachment, final MultipartPositioning.Positioner<Part, RenderContext<RenderableState>> positioner, final RenderContext<RenderableState> renderContext) {
        GL11.glPushMatrix();
        GL11.glPushAttrib(8193);
        if (compatibleAttachment.getPositioning() != null) {}
        final ItemAttachment<?> itemAttachment = compatibleAttachment.getAttachment();
        if (positioner != null) {
            if (itemAttachment instanceof Part) {
                positioner.position((Part)itemAttachment, renderContext);
                if (DebugPositioner.isDebugModeEnabled()) {
                    DebugPositioner.position((Part)itemAttachment, renderContext);
                }
            }
            else if (itemAttachment.getRenderablePart() != null) {
                positioner.position(itemAttachment.getRenderablePart(), renderContext);
                if (DebugPositioner.isDebugModeEnabled()) {
                    DebugPositioner.position(itemAttachment.getRenderablePart(), renderContext);
                }
            }
        }
        for (final Tuple<ModelBase, String> texturedModel : compatibleAttachment.getAttachment().getTexturedModels()) {
            Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(this.builder.getModId() + ":textures/models/" + texturedModel.getV()));
            GL11.glPushMatrix();
            GL11.glPushAttrib(8193);
            if (compatibleAttachment.getModelPositioning() != null) {
                compatibleAttachment.getModelPositioning().accept(texturedModel.getU());
            }
            texturedModel.getU().render((Entity)renderContext.getPlayer(), renderContext.getLimbSwing(), renderContext.getFlimbSwingAmount(), renderContext.getAgeInTicks(), renderContext.getNetHeadYaw(), renderContext.getHeadPitch(), renderContext.getScale());
            GL11.glPopAttrib();
            GL11.glPopMatrix();
        }
        final CustomRenderer<RenderableState> postRenderer = (CustomRenderer<RenderableState>)compatibleAttachment.getAttachment().getPostRenderer();
        if (postRenderer != null) {
            GL11.glPushMatrix();
            GL11.glPushAttrib(8193);
            postRenderer.render(renderContext);
            GL11.glPopAttrib();
            GL11.glPopMatrix();
        }
        for (final CompatibleAttachment<?> childAttachment : itemAttachment.getAttachments()) {
            this.renderCompatibleAttachment(childAttachment, positioner, renderContext);
        }
        GL11.glPopAttrib();
        GL11.glPopMatrix();
    }
    
    public String getTextureName() {
        return this.builder.getTextureName();
    }
    
    public ModelBase getModel() {
        return this.builder.getModel();
    }
    
    public Supplier<Float> getXRotationCenterOffset() {
        return this.builder.xCenterOffset;
    }
    
    public Supplier<Float> getYRotationCenterOffset() {
        return this.builder.yCenterOffset;
    }
    
    public Supplier<Float> getZRotationCenterOffset() {
        return this.builder.zCenterOffset;
    }
    
    public Runnable getThrownEntityPositioning() {
        return this.builder.thrownEntityPositioning;
    }
    
    private /* synthetic */ void lambda$getSimpleTransition$164(final MultipartTransition multipartTransition, final Part part, final SimplePositioning position) {
        multipartTransition.withPartPositionFunction(part, position.attachedTo, this.createWeaponPartPositionFunction(position.positioning));
    }
    
    private static /* synthetic */ void lambda$createWeaponPartPositionFunction$163(final RenderContext context) {
    }
    
    private static /* synthetic */ void lambda$createWeaponPartPositionFunction$162(final Consumer consumer, final RenderContext context) {
        consumer.accept(context);
    }
    
    private static /* synthetic */ void lambda$createWeaponPartPositionFunction$161(final RenderContext context) {
    }
    
    private static /* synthetic */ void lambda$createWeaponPartPositionFunction$160(final Consumer consumer, final RenderContext context) {
        consumer.accept(context);
    }
    
    private static /* synthetic */ void lambda$createWeaponPartPositionFunction$159(final RenderContext context) {
    }
    
    GrenadeRenderer(final Builder x0, final GrenadeRenderer$1 x1) {
        this(x0);
    }
    
    static /* synthetic */ Builder access$700(final GrenadeRenderer x0) {
        return x0.builder;
    }
    
    static /* synthetic */ List access$1200(final GrenadeRenderer x0, final List x1, final List x2, final List x3, final LinkedHashMap x4) {
        return x0.getComplexTransition(x1, x2, x3, x4);
    }
    
    static /* synthetic */ List access$1700(final GrenadeRenderer x0, final Consumer x1, final Consumer x2, final Consumer x3, final LinkedHashMap x4, final int x5) {
        return x0.getSimpleTransition(x1, x2, x3, x4, x5);
    }
    
    static {
        logger = LogManager.getLogger((Class)GrenadeRenderer.class);
    }
    
    private static class SimplePositioning
    {
        Part attachedTo;
        Consumer<RenderContext<RenderableState>> positioning;
        
        SimplePositioning(final Part attachedTo, final Consumer<RenderContext<RenderableState>> positioning) {
            super();
            this.attachedTo = attachedTo;
            this.positioning = positioning;
        }
    }
    
    public static class Builder
    {
        private ModelBase model;
        private String textureName;
        private Consumer<ItemStack> entityPositioning;
        private Runnable thrownEntityPositioning;
        private Consumer<ItemStack> inventoryPositioning;
        private Consumer<RenderContext<RenderableState>> thirdPersonPositioning;
        private Consumer<RenderContext<RenderableState>> firstPersonPositioning;
        private Consumer<RenderContext<RenderableState>> firstPersonLeftHandPositioning;
        private Consumer<RenderContext<RenderableState>> firstPersonRightHandPositioning;
        private LinkedHashMap<Part, SimplePositioning> firstPersonCustomPositioning;
        private Consumer<RenderContext<RenderableState>> firstPersonPositioningRunning;
        private Consumer<RenderContext<RenderableState>> firstPersonLeftHandPositioningRunning;
        private Consumer<RenderContext<RenderableState>> firstPersonRightHandPositioningRunning;
        private LinkedHashMap<Part, Consumer<RenderContext<RenderableState>>> firstPersonCustomPositioningRunning;
        private List<Transition<RenderContext<RenderableState>>> firstPersonPositioningSafetyPinOff;
        private List<Transition<RenderContext<RenderableState>>> firstPersonLeftHandPositioningSafetyPinOff;
        private List<Transition<RenderContext<RenderableState>>> firstPersonRightHandPositioningSafetyPinOff;
        private LinkedHashMap<Part, List<Transition<RenderContext<RenderableState>>>> firstPersonCustomPositioningSafetyPinOff;
        private Consumer<RenderContext<RenderableState>> firstPersonPositioningStrikerLeverOff;
        private Consumer<RenderContext<RenderableState>> firstPersonLeftHandPositioningStrikerLeverOff;
        private Consumer<RenderContext<RenderableState>> firstPersonRightHandPositioningStrikerLeverOff;
        private LinkedHashMap<Part, SimplePositioning> firstPersonCustomPositioningStrikerLeverOff;
        private List<Transition<RenderContext<RenderableState>>> firstPersonPositioningThrowing;
        private List<Transition<RenderContext<RenderableState>>> firstPersonLeftHandPositioningThrowing;
        private List<Transition<RenderContext<RenderableState>>> firstPersonRightHandPositioningThrowing;
        private LinkedHashMap<Part, List<Transition<RenderContext<RenderableState>>>> firstPersonCustomPositioningThrowing;
        private Consumer<RenderContext<RenderableState>> firstPersonPositioningThrown;
        private Consumer<RenderContext<RenderableState>> firstPersonLeftHandPositioningThrown;
        private Consumer<RenderContext<RenderableState>> firstPersonRightHandPositioningThrown;
        private LinkedHashMap<Part, SimplePositioning> firstPersonCustomPositioningThrown;
        private long totalTakingPinOffDuration;
        private long totalThrowingDuration;
        private String modId;
        private float normalRandomizingRate;
        private float normalRandomizingAmplitude;
        public int animationDuration;
        private Supplier<Float> xCenterOffset;
        private Supplier<Float> yCenterOffset;
        private Supplier<Float> zCenterOffset;
        
        public Builder() {
            super();
            this.thrownEntityPositioning = (() -> {});
            this.firstPersonCustomPositioning = new LinkedHashMap<Part, SimplePositioning>();
            this.firstPersonCustomPositioningRunning = new LinkedHashMap<Part, Consumer<RenderContext<RenderableState>>>();
            this.firstPersonCustomPositioningSafetyPinOff = new LinkedHashMap<Part, List<Transition<RenderContext<RenderableState>>>>();
            this.firstPersonCustomPositioningStrikerLeverOff = new LinkedHashMap<Part, SimplePositioning>();
            this.firstPersonCustomPositioningThrowing = new LinkedHashMap<Part, List<Transition<RenderContext<RenderableState>>>>();
            this.firstPersonCustomPositioningThrown = new LinkedHashMap<Part, SimplePositioning>();
            this.normalRandomizingRate = 0.33f;
            this.normalRandomizingAmplitude = 0.06f;
            this.animationDuration = 70;
            this.xCenterOffset = (() -> 0.0f);
            this.yCenterOffset = (() -> 0.0f);
            this.zCenterOffset = (() -> 0.0f);
        }
        
        public Builder withModId(final String modId) {
            this.modId = modId;
            return this;
        }
        
        public Builder withModel(final ModelBase model) {
            this.model = model;
            return this;
        }
        
        public Builder withAnimationDuration(final int animationDuration) {
            this.animationDuration = animationDuration;
            return this;
        }
        
        public Builder withNormalRandomizingRate(final float normalRandomizingRate) {
            this.normalRandomizingRate = normalRandomizingRate;
            return this;
        }
        
        public Builder withTextureName(final String textureName) {
            this.textureName = textureName + ".png";
            return this;
        }
        
        public Builder withEntityPositioning(final Consumer<ItemStack> entityPositioning) {
            this.entityPositioning = entityPositioning;
            return this;
        }
        
        public Builder withThrownEntityPositioning(final Runnable throwEntityPositioning) {
            this.thrownEntityPositioning = throwEntityPositioning;
            return this;
        }
        
        public Builder withInventoryPositioning(final Consumer<ItemStack> inventoryPositioning) {
            this.inventoryPositioning = inventoryPositioning;
            return this;
        }
        
        public Builder withThirdPersonPositioning(final Consumer<RenderContext<RenderableState>> thirdPersonPositioning) {
            this.thirdPersonPositioning = thirdPersonPositioning;
            return this;
        }
        
        public Builder withFirstPersonPositioning(final Consumer<RenderContext<RenderableState>> firstPersonPositioning) {
            this.firstPersonPositioning = firstPersonPositioning;
            return this;
        }
        
        public Builder withFirstPersonHandPositioning(final Consumer<RenderContext<RenderableState>> leftHand, final Consumer<RenderContext<RenderableState>> rightHand) {
            this.firstPersonLeftHandPositioning = leftHand;
            this.firstPersonRightHandPositioning = rightHand;
            return this;
        }
        
        public Builder withFirstPersonCustomPositioning(final Part part, final Part attachedTo, final Consumer<RenderContext<RenderableState>> positioning) {
            if (part instanceof DefaultPart) {
                throw new IllegalArgumentException("Part " + part + " is not custom");
            }
            if (this.firstPersonCustomPositioning.put(part, new SimplePositioning(attachedTo, positioning)) != null) {
                throw new IllegalArgumentException("Part " + part + " already added");
            }
            return this;
        }
        
        public Builder withFirstPersonPositioningRunning(final Consumer<RenderContext<RenderableState>> firstPersonPositioningRunning) {
            this.firstPersonPositioningRunning = firstPersonPositioningRunning;
            return this;
        }
        
        public Builder withFirstPersonHandPositioningRunning(final Consumer<RenderContext<RenderableState>> leftHand, final Consumer<RenderContext<RenderableState>> rightHand) {
            this.firstPersonLeftHandPositioningRunning = leftHand;
            this.firstPersonRightHandPositioningRunning = rightHand;
            return this;
        }
        
        public Builder withFirstPersonCustomPositioningRunning(final Part part, final Consumer<RenderContext<RenderableState>> positioning) {
            if (part instanceof DefaultPart) {
                throw new IllegalArgumentException("Part " + part + " is not custom");
            }
            if (this.firstPersonCustomPositioningRunning.put(part, positioning) != null) {
                throw new IllegalArgumentException("Part " + part + " already added");
            }
            return this;
        }
        
        public Builder withFirstPersonPositioningThrown(final Consumer<RenderContext<RenderableState>> firstPersonPositioningThrown) {
            this.firstPersonPositioningThrown = firstPersonPositioningThrown;
            return this;
        }
        
        public Builder withFirstPersonHandPositioningThrown(final Consumer<RenderContext<RenderableState>> leftHand, final Consumer<RenderContext<RenderableState>> rightHand) {
            this.firstPersonLeftHandPositioningThrown = leftHand;
            this.firstPersonRightHandPositioningThrown = rightHand;
            return this;
        }
        
        public Builder withFirstPersonCustomPositioningThrown(final Part part, final Part attachedTo, final Consumer<RenderContext<RenderableState>> positioning) {
            if (part instanceof DefaultPart) {
                throw new IllegalArgumentException("Part " + part + " is not custom");
            }
            if (this.firstPersonCustomPositioningThrown.put(part, new SimplePositioning(attachedTo, positioning)) != null) {
                throw new IllegalArgumentException("Part " + part + " already added");
            }
            return this;
        }
        
        @SafeVarargs
        public final Builder withFirstPersonPositioningSafetyPinOff(final Transition<RenderContext<RenderableState>>... transitions) {
            this.firstPersonPositioningSafetyPinOff = Arrays.asList(transitions);
            return this;
        }
        
        @SafeVarargs
        public final Builder withFirstPersonPositioningThrowing(final Transition<RenderContext<RenderableState>>... transitions) {
            this.firstPersonPositioningThrowing = Arrays.asList(transitions);
            return this;
        }
        
        public Builder withFirstPersonPositioningStrikerLeverOff(final Consumer<RenderContext<RenderableState>> firstPersonPositioningStrikerLeverOff) {
            this.firstPersonPositioningStrikerLeverOff = firstPersonPositioningStrikerLeverOff;
            return this;
        }
        
        @SafeVarargs
        public final Builder withFirstPersonLeftHandPositioningSafetyPinOff(final Transition<RenderContext<RenderableState>>... transitions) {
            this.firstPersonLeftHandPositioningSafetyPinOff = Arrays.asList(transitions);
            return this;
        }
        
        @SafeVarargs
        public final Builder withFirstPersonLeftHandPositioningThrowing(final Transition<RenderContext<RenderableState>>... transitions) {
            this.firstPersonLeftHandPositioningThrowing = Arrays.asList(transitions);
            return this;
        }
        
        @SafeVarargs
        public final Builder withFirstPersonRightHandPositioningThrowing(final Transition<RenderContext<RenderableState>>... transitions) {
            this.firstPersonRightHandPositioningThrowing = Arrays.asList(transitions);
            return this;
        }
        
        @SafeVarargs
        public final Builder withFirstPersonRightHandPositioningSafetyPinOff(final Transition<RenderContext<RenderableState>>... transitions) {
            this.firstPersonRightHandPositioningSafetyPinOff = Arrays.asList(transitions);
            return this;
        }
        
        public Builder withFirstPersonHandPositioningStrikerLevelOff(final Consumer<RenderContext<RenderableState>> leftHand, final Consumer<RenderContext<RenderableState>> rightHand) {
            this.firstPersonLeftHandPositioningStrikerLeverOff = leftHand;
            this.firstPersonRightHandPositioningStrikerLeverOff = rightHand;
            return this;
        }
        
        public Builder withFirstPersonCustomPositioningStrikerLeverOff(final Part part, final Part attachedTo, final Consumer<RenderContext<RenderableState>> positioning) {
            if (part instanceof DefaultPart) {
                throw new IllegalArgumentException("Part " + part + " is not custom");
            }
            if (this.firstPersonCustomPositioningStrikerLeverOff.put(part, new SimplePositioning(attachedTo, positioning)) != null) {
                throw new IllegalArgumentException("Part " + part + " already added");
            }
            return this;
        }
        
        @SafeVarargs
        public final Builder withFirstPersonCustomPositioningSafetyPinOff(final Part part, final Transition<RenderContext<RenderableState>>... transitions) {
            if (part instanceof DefaultPart) {
                throw new IllegalArgumentException("Part " + part + " is not custom");
            }
            this.firstPersonCustomPositioningSafetyPinOff.put(part, Arrays.asList(transitions));
            return this;
        }
        
        @SafeVarargs
        public final Builder withFirstPersonCustomPositioningThrowing(final Part part, final Transition<RenderContext<RenderableState>>... transitions) {
            if (part instanceof DefaultPart) {
                throw new IllegalArgumentException("Part " + part + " is not custom");
            }
            this.firstPersonCustomPositioningThrowing.put(part, Arrays.asList(transitions));
            return this;
        }
        
        public Builder withEntityRotationCenterOffsets(final Supplier<Float> xCenterOffset, final Supplier<Float> yCenterOffset, final Supplier<Float> zCenterOffset) {
            this.xCenterOffset = xCenterOffset;
            this.yCenterOffset = yCenterOffset;
            this.zCenterOffset = zCenterOffset;
            return this;
        }
        
        public GrenadeRenderer build() {
            if (!CompatibilityProvider.compatibility.isClientSide()) {
                return null;
            }
            if (this.modId == null) {
                throw new IllegalStateException("ModId is not set");
            }
            if (this.inventoryPositioning == null) {
                this.inventoryPositioning = (itemStack -> GL11.glTranslatef(0.0f, 0.12f, 0.0f));
            }
            if (this.entityPositioning == null) {
                this.entityPositioning = (itemStack -> {});
            }
            final GrenadeRenderer renderer = new GrenadeRenderer(this, null);
            if (this.firstPersonPositioning == null) {
                this.firstPersonPositioning = (renderContext -> {});
            }
            if (this.firstPersonPositioningSafetyPinOff == null) {
                this.firstPersonPositioningSafetyPinOff = Collections.singletonList(new Transition<RenderContext<RenderableState>>(this.firstPersonPositioning, this.animationDuration));
            }
            if (this.firstPersonPositioningThrowing == null) {
                this.firstPersonPositioningThrowing = Collections.singletonList(new Transition<RenderContext<RenderableState>>(this.firstPersonPositioning, this.animationDuration));
            }
            final Iterator<Transition<RenderContext<RenderableState>>> iterator = this.firstPersonPositioningSafetyPinOff.iterator();
            Transition<RenderContext<RenderableState>> t = null;
            while (iterator.hasNext()) {
                t = iterator.next();
                this.totalTakingPinOffDuration += t.getDuration();
                this.totalTakingPinOffDuration += t.getPause();
            }
            final Iterator<Transition<RenderContext<RenderableState>>> iterator2 = this.firstPersonPositioningThrowing.iterator();
            while (iterator2.hasNext()) {
                t = iterator2.next();
                this.totalThrowingDuration += t.getDuration();
                this.totalThrowingDuration += t.getPause();
            }
            if (this.firstPersonPositioningRunning == null) {
                this.firstPersonPositioningRunning = this.firstPersonPositioning;
            }
            if (this.firstPersonPositioningStrikerLeverOff == null) {
                if (this.firstPersonPositioningSafetyPinOff != null && !this.firstPersonPositioningSafetyPinOff.isEmpty()) {
                    this.firstPersonPositioningStrikerLeverOff = this.firstPersonPositioningSafetyPinOff.get(this.firstPersonPositioningSafetyPinOff.size() - 1).getItemPositioning();
                }
                if (this.firstPersonPositioningStrikerLeverOff == null) {
                    this.firstPersonPositioningStrikerLeverOff = this.firstPersonPositioning;
                }
            }
            if (this.firstPersonPositioningThrown == null) {
                if (this.firstPersonPositioningThrowing != null && !this.firstPersonPositioningThrowing.isEmpty()) {
                    this.firstPersonPositioningThrown = this.firstPersonPositioningThrowing.get(this.firstPersonPositioningThrowing.size() - 1).getItemPositioning();
                }
                if (this.firstPersonPositioningThrown == null) {
                    this.firstPersonPositioningThrown = this.firstPersonPositioning;
                }
            }
            if (this.thirdPersonPositioning == null) {
                this.thirdPersonPositioning = (context -> {
                    GL11.glTranslatef(-0.4f, 0.2f, 0.4f);
                    GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
                    GL11.glRotatef(70.0f, 1.0f, 0.0f, 0.0f);
                    return;
                });
            }
            if (this.firstPersonLeftHandPositioning == null) {
                this.firstPersonLeftHandPositioning = (context -> {});
            }
            if (this.firstPersonLeftHandPositioningSafetyPinOff == null) {
                this.firstPersonLeftHandPositioningSafetyPinOff = this.firstPersonPositioningSafetyPinOff.stream().map(t -> new Transition(c -> {}, 0L)).collect((Collector<? super Object, ?, List<Transition<RenderContext<RenderableState>>>>)Collectors.toList());
            }
            if (this.firstPersonLeftHandPositioningThrowing == null) {
                this.firstPersonLeftHandPositioningThrowing = this.firstPersonPositioningThrowing.stream().map(t -> new Transition(c -> {}, 0L)).collect((Collector<? super Object, ?, List<Transition<RenderContext<RenderableState>>>>)Collectors.toList());
            }
            if (this.firstPersonRightHandPositioningThrowing == null) {
                this.firstPersonRightHandPositioningThrowing = this.firstPersonPositioningThrowing.stream().map(t -> new Transition(c -> {}, 0L)).collect((Collector<? super Object, ?, List<Transition<RenderContext<RenderableState>>>>)Collectors.toList());
            }
            if (this.firstPersonLeftHandPositioningRunning == null) {
                this.firstPersonLeftHandPositioningRunning = this.firstPersonLeftHandPositioning;
            }
            if (this.firstPersonLeftHandPositioningStrikerLeverOff == null) {
                if (this.firstPersonLeftHandPositioningSafetyPinOff != null && !this.firstPersonLeftHandPositioningSafetyPinOff.isEmpty()) {
                    this.firstPersonLeftHandPositioningStrikerLeverOff = this.firstPersonLeftHandPositioningSafetyPinOff.get(this.firstPersonLeftHandPositioningSafetyPinOff.size() - 1).getItemPositioning();
                }
                if (this.firstPersonLeftHandPositioningStrikerLeverOff == null) {
                    this.firstPersonLeftHandPositioningStrikerLeverOff = this.firstPersonLeftHandPositioning;
                }
            }
            if (this.firstPersonLeftHandPositioningThrown == null) {
                if (this.firstPersonLeftHandPositioningThrowing != null && !this.firstPersonLeftHandPositioningThrowing.isEmpty()) {
                    this.firstPersonLeftHandPositioningThrown = this.firstPersonLeftHandPositioningThrowing.get(this.firstPersonLeftHandPositioningThrowing.size() - 1).getItemPositioning();
                }
                if (this.firstPersonLeftHandPositioningThrown == null) {
                    this.firstPersonLeftHandPositioningThrown = this.firstPersonLeftHandPositioning;
                }
            }
            if (this.firstPersonRightHandPositioning == null) {
                this.firstPersonRightHandPositioning = (context -> {});
            }
            if (this.firstPersonRightHandPositioningSafetyPinOff == null) {
                this.firstPersonRightHandPositioningSafetyPinOff = this.firstPersonPositioningSafetyPinOff.stream().map(t -> new Transition(c -> {}, 0L)).collect((Collector<? super Object, ?, List<Transition<RenderContext<RenderableState>>>>)Collectors.toList());
            }
            if (this.firstPersonRightHandPositioningThrowing == null) {
                this.firstPersonRightHandPositioningThrowing = this.firstPersonPositioningThrowing.stream().map(t -> new Transition(c -> {}, 0L)).collect((Collector<? super Object, ?, List<Transition<RenderContext<RenderableState>>>>)Collectors.toList());
            }
            if (this.firstPersonRightHandPositioningRunning == null) {
                this.firstPersonRightHandPositioningRunning = this.firstPersonRightHandPositioning;
            }
            if (this.firstPersonRightHandPositioningStrikerLeverOff == null) {
                if (this.firstPersonRightHandPositioningSafetyPinOff != null && !this.firstPersonRightHandPositioningSafetyPinOff.isEmpty()) {
                    this.firstPersonRightHandPositioningStrikerLeverOff = this.firstPersonRightHandPositioningSafetyPinOff.get(this.firstPersonRightHandPositioningSafetyPinOff.size() - 1).getItemPositioning();
                }
                if (this.firstPersonRightHandPositioningStrikerLeverOff == null) {
                    this.firstPersonRightHandPositioningStrikerLeverOff = this.firstPersonRightHandPositioning;
                }
            }
            if (this.firstPersonRightHandPositioningThrown == null) {
                if (this.firstPersonRightHandPositioningThrowing != null && !this.firstPersonRightHandPositioningThrowing.isEmpty()) {
                    this.firstPersonRightHandPositioningThrown = this.firstPersonRightHandPositioningThrowing.get(this.firstPersonRightHandPositioningThrowing.size() - 1).getItemPositioning();
                }
                if (this.firstPersonRightHandPositioningThrown == null) {
                    this.firstPersonRightHandPositioningThrown = this.firstPersonRightHandPositioning;
                }
            }
            this.firstPersonCustomPositioningSafetyPinOff.forEach((p, t) -> {
                if (t.size() != this.firstPersonPositioningSafetyPinOff.size()) {
                    new IllegalStateException("Custom reloading transition number mismatch. Expected " + this.firstPersonPositioningSafetyPinOff.size() + ", actual: " + t.size());
                    throw;
                }
                else {
                    return;
                }
            });
            this.firstPersonCustomPositioningThrowing.forEach((p, t) -> {
                if (t.size() != this.firstPersonPositioningThrowing.size()) {
                    new IllegalStateException("Custom reloading transition number mismatch. Expected " + this.firstPersonPositioningThrowing.size() + ", actual: " + t.size());
                    throw;
                }
                else {
                    return;
                }
            });
            if (!this.firstPersonCustomPositioning.isEmpty() && this.firstPersonCustomPositioningStrikerLeverOff.isEmpty()) {
                this.firstPersonCustomPositioning.forEach((part, pos) -> this.firstPersonCustomPositioningStrikerLeverOff.put(part, new SimplePositioning(null, pos.positioning)));
            }
            if (!this.firstPersonCustomPositioning.isEmpty() && this.firstPersonCustomPositioningThrown.isEmpty()) {
                this.firstPersonCustomPositioning.forEach((part, pos) -> this.firstPersonCustomPositioningThrown.put(part, new SimplePositioning(null, pos.positioning)));
            }
            return renderer;
        }
        
        public Consumer<ItemStack> getEntityPositioning() {
            return this.entityPositioning;
        }
        
        public Consumer<ItemStack> getInventoryPositioning() {
            return this.inventoryPositioning;
        }
        
        public Consumer<RenderContext<RenderableState>> getThirdPersonPositioning() {
            return this.thirdPersonPositioning;
        }
        
        public String getTextureName() {
            return this.textureName;
        }
        
        public ModelBase getModel() {
            return this.model;
        }
        
        public String getModId() {
            return this.modId;
        }
        
        private /* synthetic */ void lambda$build$158(final Part part, final SimplePositioning pos) {
            this.firstPersonCustomPositioningThrown.put(part, new SimplePositioning(null, pos.positioning));
        }
        
        private /* synthetic */ void lambda$build$157(final Part part, final SimplePositioning pos) {
            this.firstPersonCustomPositioningStrikerLeverOff.put(part, new SimplePositioning(null, pos.positioning));
        }
        
        private /* synthetic */ void lambda$build$156(final Part p, final List t) {
            if (t.size() != this.firstPersonPositioningThrowing.size()) {
                throw new IllegalStateException("Custom reloading transition number mismatch. Expected " + this.firstPersonPositioningThrowing.size() + ", actual: " + t.size());
            }
        }
        
        private /* synthetic */ void lambda$build$155(final Part p, final List t) {
            if (t.size() != this.firstPersonPositioningSafetyPinOff.size()) {
                throw new IllegalStateException("Custom reloading transition number mismatch. Expected " + this.firstPersonPositioningSafetyPinOff.size() + ", actual: " + t.size());
            }
        }
        
        private static /* synthetic */ Transition lambda$build$154(final Transition t) {
            return new Transition(c -> {}, 0L);
        }
        
        private static /* synthetic */ void lambda$null$153(final RenderContext c) {
        }
        
        private static /* synthetic */ Transition lambda$build$152(final Transition t) {
            return new Transition(c -> {}, 0L);
        }
        
        private static /* synthetic */ void lambda$null$151(final RenderContext c) {
        }
        
        private static /* synthetic */ void lambda$build$150(final RenderContext context) {
        }
        
        private static /* synthetic */ Transition lambda$build$149(final Transition t) {
            return new Transition(c -> {}, 0L);
        }
        
        private static /* synthetic */ void lambda$null$148(final RenderContext c) {
        }
        
        private static /* synthetic */ Transition lambda$build$147(final Transition t) {
            return new Transition(c -> {}, 0L);
        }
        
        private static /* synthetic */ void lambda$null$146(final RenderContext c) {
        }
        
        private static /* synthetic */ Transition lambda$build$145(final Transition t) {
            return new Transition(c -> {}, 0L);
        }
        
        private static /* synthetic */ void lambda$null$144(final RenderContext c) {
        }
        
        private static /* synthetic */ void lambda$build$143(final RenderContext context) {
        }
        
        private static /* synthetic */ void lambda$build$142(final RenderContext context) {
            GL11.glTranslatef(-0.4f, 0.2f, 0.4f);
            GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(70.0f, 1.0f, 0.0f, 0.0f);
        }
        
        private static /* synthetic */ void lambda$build$141(final RenderContext renderContext) {
        }
        
        private static /* synthetic */ void lambda$build$140(final ItemStack itemStack) {
        }
        
        private static /* synthetic */ void lambda$build$139(final ItemStack itemStack) {
            GL11.glTranslatef(0.0f, 0.12f, 0.0f);
        }
        
        private static /* synthetic */ Float lambda$new$138() {
            return 0.0f;
        }
        
        private static /* synthetic */ Float lambda$new$137() {
            return 0.0f;
        }
        
        private static /* synthetic */ Float lambda$new$136() {
            return 0.0f;
        }
        
        private static /* synthetic */ void lambda$new$135() {
        }
        
        static /* synthetic */ long access$200(final Builder x0) {
            return x0.totalTakingPinOffDuration;
        }
        
        static /* synthetic */ long access$300(final Builder x0) {
            return x0.totalThrowingDuration;
        }
        
        static /* synthetic */ float access$400(final Builder x0) {
            return x0.normalRandomizingAmplitude;
        }
        
        static /* synthetic */ float access$500(final Builder x0) {
            return x0.normalRandomizingRate;
        }
        
        static /* synthetic */ Consumer access$600(final Builder x0) {
            return x0.firstPersonPositioningRunning;
        }
        
        static /* synthetic */ List access$800(final Builder x0) {
            return x0.firstPersonPositioningSafetyPinOff;
        }
        
        static /* synthetic */ List access$900(final Builder x0) {
            return x0.firstPersonLeftHandPositioningSafetyPinOff;
        }
        
        static /* synthetic */ List access$1000(final Builder x0) {
            return x0.firstPersonRightHandPositioningSafetyPinOff;
        }
        
        static /* synthetic */ LinkedHashMap access$1100(final Builder x0) {
            return x0.firstPersonCustomPositioningSafetyPinOff;
        }
        
        static /* synthetic */ Consumer access$1300(final Builder x0) {
            return x0.firstPersonPositioningStrikerLeverOff;
        }
        
        static /* synthetic */ Consumer access$1400(final Builder x0) {
            return x0.firstPersonLeftHandPositioningStrikerLeverOff;
        }
        
        static /* synthetic */ Consumer access$1500(final Builder x0) {
            return x0.firstPersonRightHandPositioningStrikerLeverOff;
        }
        
        static /* synthetic */ LinkedHashMap access$1600(final Builder x0) {
            return x0.firstPersonCustomPositioningStrikerLeverOff;
        }
        
        static /* synthetic */ List access$1800(final Builder x0) {
            return x0.firstPersonPositioningThrowing;
        }
        
        static /* synthetic */ List access$1900(final Builder x0) {
            return x0.firstPersonLeftHandPositioningThrowing;
        }
        
        static /* synthetic */ List access$2000(final Builder x0) {
            return x0.firstPersonRightHandPositioningThrowing;
        }
        
        static /* synthetic */ LinkedHashMap access$2100(final Builder x0) {
            return x0.firstPersonCustomPositioningThrowing;
        }
        
        static /* synthetic */ Consumer access$2200(final Builder x0) {
            return x0.firstPersonPositioningThrown;
        }
        
        static /* synthetic */ Consumer access$2300(final Builder x0) {
            return x0.firstPersonLeftHandPositioningThrown;
        }
        
        static /* synthetic */ Consumer access$2400(final Builder x0) {
            return x0.firstPersonRightHandPositioningThrown;
        }
        
        static /* synthetic */ LinkedHashMap access$2500(final Builder x0) {
            return x0.firstPersonCustomPositioningThrown;
        }
        
        static /* synthetic */ Consumer access$2600(final Builder x0) {
            return x0.firstPersonPositioning;
        }
        
        static /* synthetic */ Consumer access$2700(final Builder x0) {
            return x0.firstPersonLeftHandPositioning;
        }
        
        static /* synthetic */ Consumer access$2800(final Builder x0) {
            return x0.firstPersonRightHandPositioning;
        }
        
        static /* synthetic */ LinkedHashMap access$2900(final Builder x0) {
            return x0.firstPersonCustomPositioning;
        }
        
        static /* synthetic */ Supplier access$3000(final Builder x0) {
            return x0.xCenterOffset;
        }
        
        static /* synthetic */ Supplier access$3100(final Builder x0) {
            return x0.yCenterOffset;
        }
        
        static /* synthetic */ Supplier access$3200(final Builder x0) {
            return x0.zCenterOffset;
        }
        
        static /* synthetic */ Runnable access$3300(final Builder x0) {
            return x0.thrownEntityPositioning;
        }
    }
    
    private static class StateManagerKey
    {
        EntityPlayer player;
        int slot;
        
        public StateManagerKey(final EntityPlayer player, final int slot) {
            super();
            this.slot = -1;
            this.player = player;
            this.slot = slot;
        }
        
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = 31 * result + ((this.player == null) ? 0 : this.player.hashCode());
            result = 31 * result + this.slot;
            return result;
        }
        
        @Override
        public boolean equals(final Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (this.getClass() != obj.getClass()) {
                return false;
            }
            final StateManagerKey other = (StateManagerKey)obj;
            if (this.player == null) {
                if (other.player != null) {
                    return false;
                }
            }
            else if (!this.player.equals((Object)other.player)) {
                return false;
            }
            return this.slot == other.slot;
        }
    }
    
    private class WeaponPositionProvider implements MultipartTransitionProvider<RenderableState, Part, RenderContext<RenderableState>>
    {
        final /* synthetic */ GrenadeRenderer this$0;
        
        private WeaponPositionProvider(final GrenadeRenderer this$0) {
            this.this$0 = this$0;
            super();
        }
        
        @Override
        public List<MultipartTransition<Part, RenderContext<RenderableState>>> getPositioning(final RenderableState state) {
            switch (state) {
                case SAFETY_PIN_OFF: {
                    return GrenadeRenderer.this.getComplexTransition(this.this$0.builder.firstPersonPositioningSafetyPinOff, this.this$0.builder.firstPersonLeftHandPositioningSafetyPinOff, this.this$0.builder.firstPersonRightHandPositioningSafetyPinOff, this.this$0.builder.firstPersonCustomPositioningSafetyPinOff);
                }
                case STRIKER_LEVEL_OFF: {
                    return GrenadeRenderer.this.getSimpleTransition(this.this$0.builder.firstPersonPositioningStrikerLeverOff, this.this$0.builder.firstPersonLeftHandPositioningStrikerLeverOff, this.this$0.builder.firstPersonRightHandPositioningStrikerLeverOff, this.this$0.builder.firstPersonCustomPositioningStrikerLeverOff, this.this$0.builder.animationDuration);
                }
                case THROWING: {
                    return GrenadeRenderer.this.getComplexTransition(this.this$0.builder.firstPersonPositioningThrowing, this.this$0.builder.firstPersonLeftHandPositioningThrowing, this.this$0.builder.firstPersonRightHandPositioningThrowing, this.this$0.builder.firstPersonCustomPositioningThrowing);
                }
                case THROWN: {
                    return GrenadeRenderer.this.getSimpleTransition(this.this$0.builder.firstPersonPositioningThrown, this.this$0.builder.firstPersonLeftHandPositioningThrown, this.this$0.builder.firstPersonRightHandPositioningThrown, this.this$0.builder.firstPersonCustomPositioningThrown, this.this$0.builder.animationDuration);
                }
                case NORMAL:
                case RUNNING: {
                    return GrenadeRenderer.this.getSimpleTransition(this.this$0.builder.firstPersonPositioning, this.this$0.builder.firstPersonLeftHandPositioning, this.this$0.builder.firstPersonRightHandPositioning, this.this$0.builder.firstPersonCustomPositioning, this.this$0.builder.animationDuration);
                }
                default: {
                    return null;
                }
            }
        }
        
        @Override
        public /* bridge */ List getPositioning(final Object o) {
            return this.getPositioning((RenderableState)o);
        }
        
        WeaponPositionProvider(final GrenadeRenderer x0, final GrenadeRenderer$1 x1) {
            this(x0);
        }
    }
}
