package com.vicmatskiv.weaponlib.melee;

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
import java.util.*;
import com.vicmatskiv.weaponlib.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import java.util.stream.*;

public class MeleeRenderer extends CompatibleMeleeRenderer
{
    private static final Logger logger;
    private static final float DEFAULT_RANDOMIZING_RATE = 0.33f;
    private static final float DEFAULT_NORMAL_RANDOMIZING_AMPLITUDE = 0.06f;
    private static final int DEFAULT_ANIMATION_DURATION = 70;
    private Builder builder;
    private Map<EntityPlayer, MultipartRenderStateManager<RenderableState, Part, RenderContext<RenderableState>>> firstPersonStateManagers;
    private MultipartTransitionProvider<RenderableState, Part, RenderContext<RenderableState>> weaponTransitionProvider;
    protected ClientModContext clientModContext;
    
    private MeleeRenderer(final Builder builder) {
        super(builder);
        this.builder = builder;
        this.firstPersonStateManagers = new HashMap<EntityPlayer, MultipartRenderStateManager<RenderableState, Part, RenderContext<RenderableState>>>();
        this.weaponTransitionProvider = new WeaponPositionProvider(this);
    }
    
    protected long getTotalAttackDuration() {
        return this.builder.totalAttackingDuration;
    }
    
    protected long getTotalHeavyAttackDuration() {
        return this.builder.totalHeavyAttackingDuration;
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
        PlayerMeleeInstance playerMeleeInstance = null;
        if (playerItemInstance == null || !(playerItemInstance instanceof PlayerMeleeInstance) || playerItemInstance.getItem() != itemStack.getItem()) {
            MeleeRenderer.logger.error("Invalid or mismatching item. Player item instance: {}. Item stack: {}", new Object[] { playerItemInstance, itemStack });
        }
        else {
            playerMeleeInstance = (PlayerMeleeInstance)playerItemInstance;
        }
        if (playerMeleeInstance != null) {
            final AsyncMeleeState asyncWeaponState = this.getNextNonExpiredState(playerMeleeInstance);
            switch (asyncWeaponState.getState()) {
                case ATTACKING:
                case ATTACKING_STABBING: {
                    currentState = RenderableState.ATTACKING;
                    break;
                }
                case HEAVY_ATTACKING:
                case HEAVY_ATTACKING_STABBING: {
                    currentState = RenderableState.HEAVY_ATTACKING;
                    break;
                }
                case MODIFYING:
                case MODIFYING_REQUESTED:
                case NEXT_ATTACHMENT:
                case NEXT_ATTACHMENT_REQUESTED: {
                    currentState = RenderableState.MODIFYING;
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
            MeleeRenderer.logger.trace("Rendering state {} created from {}", new Object[] { currentState, asyncWeaponState.getState() });
        }
        if (currentState == null) {
            currentState = RenderableState.NORMAL;
        }
        MultipartRenderStateManager<RenderableState, Part, RenderContext<RenderableState>> stateManager = this.firstPersonStateManagers.get(player);
        if (stateManager == null) {
            stateManager = new MultipartRenderStateManager<RenderableState, Part, RenderContext<RenderableState>>(currentState, this.weaponTransitionProvider, Part.MAIN_ITEM);
            this.firstPersonStateManagers.put(player, stateManager);
        }
        else {
            stateManager.setState(currentState, true, currentState == RenderableState.ATTACKING);
        }
        return new StateDescriptor(playerMeleeInstance, stateManager, rate, amplitude);
    }
    
    private AsyncMeleeState getNextNonExpiredState(final PlayerMeleeInstance playerWeaponState) {
        AsyncMeleeState asyncWeaponState = null;
        while ((asyncWeaponState = playerWeaponState.nextHistoryState()) != null && System.currentTimeMillis() > asyncWeaponState.getTimestamp() + asyncWeaponState.getDuration()) {}
        return asyncWeaponState;
    }
    
    private Consumer<RenderContext<RenderableState>> createWeaponPartPositionFunction(final Transition<RenderContext<RenderableState>> t) {
        if (t == null) {
            return context -> {};
        }
        final Consumer<RenderContext<RenderableState>> weaponPositionFunction = t.getItemPositioning();
        if (weaponPositionFunction != null) {
            return context -> consumer.accept(context);
        }
        return context -> {};
    }
    
    private Consumer<RenderContext<RenderableState>> createWeaponPartPositionFunction(final Consumer<RenderContext<RenderableState>> weaponPositionFunction) {
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
            final MultipartTransition<Part, RenderContext<RenderableState>> t = new MultipartTransition<Part, RenderContext<RenderableState>>(p.getDuration(), pause).withPartPositionFunction(Part.MAIN_ITEM, this.createWeaponPartPositionFunction(p)).withPartPositionFunction(Part.LEFT_HAND, this.createWeaponPartPositionFunction(l)).withPartPositionFunction(Part.RIGHT_HAND, this.createWeaponPartPositionFunction(r));
            for (final Map.Entry<Part, List<Transition<RenderContext<RenderableState>>>> e : custom.entrySet()) {
                final List<Transition<RenderContext<RenderableState>>> partTransitions = e.getValue();
                Transition<RenderContext<RenderableState>> partTransition = null;
                if (partTransitions != null && partTransitions.size() > i) {
                    partTransition = partTransitions.get(i);
                }
                else {
                    MeleeRenderer.logger.warn("Transition not defined for part {}", new Object[] { custom });
                }
                t.withPartPositionFunction(e.getKey(), this.createWeaponPartPositionFunction(partTransition));
            }
            result.add(t);
        }
        return result;
    }
    
    private List<MultipartTransition<Part, RenderContext<RenderableState>>> getSimpleTransition(final Consumer<RenderContext<RenderableState>> w, final Consumer<RenderContext<RenderableState>> lh, final Consumer<RenderContext<RenderableState>> rh, final LinkedHashMap<Part, Consumer<RenderContext<RenderableState>>> custom, final int duration) {
        final MultipartTransition<Part, RenderContext<RenderableState>> mt = new MultipartTransition<Part, RenderContext<RenderableState>>(duration, 0L).withPartPositionFunction(Part.MAIN_ITEM, this.createWeaponPartPositionFunction(w)).withPartPositionFunction(Part.LEFT_HAND, this.createWeaponPartPositionFunction(lh)).withPartPositionFunction(Part.RIGHT_HAND, this.createWeaponPartPositionFunction(rh));
        custom.forEach((part, position) -> multipartTransition.withPartPositionFunction(part, this.createWeaponPartPositionFunction(position)));
        return Collections.singletonList(mt);
    }
    
    public void renderItem(final ItemStack weaponItemStack, final RenderContext<RenderableState> renderContext, final MultipartPositioning.Positioner<Part, RenderContext<RenderableState>> positioner) {
        List<CompatibleAttachment<? extends AttachmentContainer>> attachments = null;
        if (this.builder.getModel() instanceof ModelWithAttachments) {
            attachments = ((ItemMelee)weaponItemStack.getItem()).getActiveAttachments(renderContext.getPlayer(), weaponItemStack);
        }
        if (this.builder.getTextureName() != null) {
            Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(this.builder.getModId() + ":textures/models/" + this.builder.getTextureName()));
        }
        else {
            String textureName = null;
            final CompatibleAttachment<?> compatibleSkin = attachments.stream().filter(ca -> ca.getAttachment() instanceof MeleeSkin).findAny().orElse(null);
            if (compatibleSkin != null) {
                final PlayerItemInstance<?> itemInstance = this.getClientModContext().getPlayerItemInstanceRegistry().getItemInstance(renderContext.getPlayer(), weaponItemStack);
                if (itemInstance instanceof PlayerMeleeInstance) {
                    final int textureIndex = ((PlayerMeleeInstance)itemInstance).getActiveTextureIndex();
                    if (textureIndex >= 0) {
                        textureName = ((MeleeSkin)compatibleSkin.getAttachment()).getTextureVariant(textureIndex) + ".png";
                    }
                }
            }
            if (textureName == null) {
                final ItemMelee weapon = (ItemMelee)weaponItemStack.getItem();
                textureName = weapon.getTextureName();
            }
            Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(this.builder.getModId() + ":textures/models/" + textureName));
        }
        this.builder.getModel().render((Entity)null, renderContext.getLimbSwing(), renderContext.getFlimbSwingAmount(), renderContext.getAgeInTicks(), renderContext.getNetHeadYaw(), renderContext.getHeadPitch(), renderContext.getScale());
        if (attachments != null) {
            this.renderAttachments(positioner, renderContext, attachments);
        }
    }
    
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
        if (compatibleAttachment.getPositioning() != null) {
            compatibleAttachment.getPositioning().accept(renderContext.getPlayer(), renderContext.getWeapon());
        }
        final ItemAttachment<?> itemAttachment = compatibleAttachment.getAttachment();
        if (positioner != null) {
            if (itemAttachment instanceof Part) {
                positioner.position((Part)itemAttachment, renderContext);
            }
            else if (itemAttachment.getRenderablePart() != null) {
                positioner.position(itemAttachment.getRenderablePart(), renderContext);
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
    
    public boolean hasRecoilPositioning() {
        return this.builder.hasRecoilPositioningDefined;
    }
    
    @Override
    protected BiConsumer<Part, RenderContext<RenderableState>> getPartDebugPositioning() {
        return this.builder.partDebugPositioning;
    }
    
    private static /* synthetic */ boolean lambda$renderItem$128(final CompatibleAttachment ca) {
        return ca.getAttachment() instanceof MeleeSkin;
    }
    
    private /* synthetic */ void lambda$getSimpleTransition$127(final MultipartTransition multipartTransition, final Part part, final Consumer position) {
        multipartTransition.withPartPositionFunction(part, this.createWeaponPartPositionFunction(position));
    }
    
    private static /* synthetic */ void lambda$createWeaponPartPositionFunction$126(final RenderContext context) {
    }
    
    private static /* synthetic */ void lambda$createWeaponPartPositionFunction$125(final Consumer consumer, final RenderContext context) {
        consumer.accept(context);
    }
    
    private static /* synthetic */ void lambda$createWeaponPartPositionFunction$124(final RenderContext context) {
    }
    
    private static /* synthetic */ void lambda$createWeaponPartPositionFunction$123(final Consumer consumer, final RenderContext context) {
        consumer.accept(context);
    }
    
    private static /* synthetic */ void lambda$createWeaponPartPositionFunction$122(final RenderContext context) {
    }
    
    MeleeRenderer(final Builder x0, final MeleeRenderer$1 x1) {
        this(x0);
    }
    
    static /* synthetic */ Builder access$700(final MeleeRenderer x0) {
        return x0.builder;
    }
    
    static /* synthetic */ List access$1200(final MeleeRenderer x0, final Consumer x1, final Consumer x2, final Consumer x3, final LinkedHashMap x4, final int x5) {
        return x0.getSimpleTransition(x1, x2, x3, x4, x5);
    }
    
    static /* synthetic */ List access$1900(final MeleeRenderer x0, final List x1, final List x2, final List x3, final LinkedHashMap x4) {
        return x0.getComplexTransition(x1, x2, x3, x4);
    }
    
    static {
        logger = LogManager.getLogger((Class)MeleeRenderer.class);
    }
    
    public static class Builder
    {
        private ModelBase model;
        private String textureName;
        private BiConsumer<Part, RenderContext<RenderableState>> partDebugPositioning;
        private Consumer<ItemStack> entityPositioning;
        private Consumer<ItemStack> inventoryPositioning;
        private Consumer<RenderContext<RenderableState>> thirdPersonPositioning;
        private Consumer<RenderContext<RenderableState>> firstPersonPositioning;
        private Consumer<RenderContext<RenderableState>> firstPersonPositioningRunning;
        private Consumer<RenderContext<RenderableState>> firstPersonPositioningModifying;
        private Consumer<RenderContext<RenderableState>> firstPersonLeftHandPositioning;
        private Consumer<RenderContext<RenderableState>> firstPersonLeftHandPositioningRunning;
        private Consumer<RenderContext<RenderableState>> firstPersonLeftHandPositioningModifying;
        private Consumer<RenderContext<RenderableState>> firstPersonRightHandPositioning;
        private Consumer<RenderContext<RenderableState>> firstPersonRightHandPositioningRunning;
        private Consumer<RenderContext<RenderableState>> firstPersonRightHandPositioningModifying;
        private List<Transition<RenderContext<RenderableState>>> firstPersonPositioningAttacking;
        private List<Transition<RenderContext<RenderableState>>> firstPersonLeftHandPositioningAttacking;
        private List<Transition<RenderContext<RenderableState>>> firstPersonRightHandPositioningAttacking;
        private List<Transition<RenderContext<RenderableState>>> firstPersonPositioningHeavyAttacking;
        private List<Transition<RenderContext<RenderableState>>> firstPersonLeftHandPositioningHeavyAttacking;
        private List<Transition<RenderContext<RenderableState>>> firstPersonRightHandPositioningHeavyAttacking;
        private long totalAttackingDuration;
        private long totalHeavyAttackingDuration;
        private String modId;
        private float normalRandomizingRate;
        private float normalRandomizingAmplitude;
        private LinkedHashMap<Part, Consumer<RenderContext<RenderableState>>> firstPersonCustomPositioning;
        private LinkedHashMap<Part, List<Transition<RenderContext<RenderableState>>>> firstPersonCustomPositioningAttacking;
        private LinkedHashMap<Part, List<Transition<RenderContext<RenderableState>>>> firstPersonCustomPositioningHeavyAttacking;
        private LinkedHashMap<Part, List<Transition<RenderContext<RenderableState>>>> firstPersonCustomPositioningEjectSpentRound;
        private boolean hasRecoilPositioningDefined;
        public int animationDuration;
        
        public Builder() {
            super();
            this.normalRandomizingRate = 0.33f;
            this.normalRandomizingAmplitude = 0.06f;
            this.firstPersonCustomPositioning = new LinkedHashMap<Part, Consumer<RenderContext<RenderableState>>>();
            this.firstPersonCustomPositioningAttacking = new LinkedHashMap<Part, List<Transition<RenderContext<RenderableState>>>>();
            this.firstPersonCustomPositioningHeavyAttacking = new LinkedHashMap<Part, List<Transition<RenderContext<RenderableState>>>>();
            this.firstPersonCustomPositioningEjectSpentRound = new LinkedHashMap<Part, List<Transition<RenderContext<RenderableState>>>>();
            this.animationDuration = 70;
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
        
        public Builder withInventoryPositioning(final Consumer<ItemStack> inventoryPositioning) {
            this.inventoryPositioning = inventoryPositioning;
            return this;
        }
        
        public Builder withPartDebugPositioning(final BiConsumer<Part, RenderContext<RenderableState>> partDebugPositioning) {
            this.partDebugPositioning = partDebugPositioning;
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
        
        public Builder withFirstPersonPositioningRunning(final Consumer<RenderContext<RenderableState>> firstPersonPositioningRunning) {
            this.firstPersonPositioningRunning = firstPersonPositioningRunning;
            return this;
        }
        
        @SafeVarargs
        public final Builder withFirstPersonPositioningAttacking(final Transition<RenderContext<RenderableState>>... transitions) {
            this.firstPersonPositioningAttacking = Arrays.asList(transitions);
            return this;
        }
        
        @SafeVarargs
        public final Builder withFirstPersonPositioningHeavyAttacking(final Transition<RenderContext<RenderableState>>... transitions) {
            this.firstPersonPositioningHeavyAttacking = Arrays.asList(transitions);
            return this;
        }
        
        public Builder withFirstPersonPositioningModifying(final Consumer<RenderContext<RenderableState>> firstPersonPositioningModifying) {
            this.firstPersonPositioningModifying = firstPersonPositioningModifying;
            return this;
        }
        
        public Builder withFirstPersonHandPositioning(final Consumer<RenderContext<RenderableState>> leftHand, final Consumer<RenderContext<RenderableState>> rightHand) {
            this.firstPersonLeftHandPositioning = leftHand;
            this.firstPersonRightHandPositioning = rightHand;
            return this;
        }
        
        public Builder withFirstPersonHandPositioningRunning(final Consumer<RenderContext<RenderableState>> leftHand, final Consumer<RenderContext<RenderableState>> rightHand) {
            this.firstPersonLeftHandPositioningRunning = leftHand;
            this.firstPersonRightHandPositioningRunning = rightHand;
            return this;
        }
        
        @SafeVarargs
        public final Builder withFirstPersonLeftHandPositioningAttacking(final Transition<RenderContext<RenderableState>>... transitions) {
            this.firstPersonLeftHandPositioningAttacking = Arrays.asList(transitions);
            return this;
        }
        
        @SafeVarargs
        public final Builder withFirstPersonLeftHandPositioningHeavyAttacking(final Transition<RenderContext<RenderableState>>... transitions) {
            this.firstPersonLeftHandPositioningHeavyAttacking = Arrays.asList(transitions);
            return this;
        }
        
        @SafeVarargs
        public final Builder withFirstPersonRightHandPositioningHeavyAttacking(final Transition<RenderContext<RenderableState>>... transitions) {
            this.firstPersonRightHandPositioningHeavyAttacking = Arrays.asList(transitions);
            return this;
        }
        
        @SafeVarargs
        public final Builder withFirstPersonRightHandPositioningAttacking(final Transition<RenderContext<RenderableState>>... transitions) {
            this.firstPersonRightHandPositioningAttacking = Arrays.asList(transitions);
            return this;
        }
        
        public Builder withFirstPersonHandPositioningModifying(final Consumer<RenderContext<RenderableState>> leftHand, final Consumer<RenderContext<RenderableState>> rightHand) {
            this.firstPersonLeftHandPositioningModifying = leftHand;
            this.firstPersonRightHandPositioningModifying = rightHand;
            return this;
        }
        
        public Builder withFirstPersonCustomPositioning(final Part part, final Consumer<RenderContext<RenderableState>> positioning) {
            if (part instanceof DefaultPart) {
                throw new IllegalArgumentException("Part " + part + " is not custom");
            }
            if (this.firstPersonCustomPositioning.put(part, positioning) != null) {
                throw new IllegalArgumentException("Part " + part + " already added");
            }
            return this;
        }
        
        @SafeVarargs
        public final Builder withFirstPersonCustomPositioningAttacking(final Part part, final Transition<RenderContext<RenderableState>>... transitions) {
            if (part instanceof DefaultPart) {
                throw new IllegalArgumentException("Part " + part + " is not custom");
            }
            this.firstPersonCustomPositioningAttacking.put(part, Arrays.asList(transitions));
            return this;
        }
        
        @SafeVarargs
        public final Builder withFirstPersonCustomPositioningHeavyAttacking(final Part part, final Transition<RenderContext<RenderableState>>... transitions) {
            if (part instanceof DefaultPart) {
                throw new IllegalArgumentException("Part " + part + " is not custom");
            }
            this.firstPersonCustomPositioningHeavyAttacking.put(part, Arrays.asList(transitions));
            return this;
        }
        
        @SafeVarargs
        public final Builder withFirstPersonCustomPositioningEjectSpentRound(final Part part, final Transition<RenderContext<RenderableState>>... transitions) {
            if (part instanceof DefaultPart) {
                throw new IllegalArgumentException("Part " + part + " is not custom");
            }
            this.firstPersonCustomPositioningEjectSpentRound.put(part, Arrays.asList(transitions));
            return this;
        }
        
        public MeleeRenderer build() {
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
            final MeleeRenderer renderer = new MeleeRenderer(this, null);
            if (this.firstPersonPositioning == null) {
                this.firstPersonPositioning = (renderContext -> {});
            }
            if (this.firstPersonPositioningAttacking == null) {
                this.firstPersonPositioningAttacking = Collections.singletonList(new Transition<RenderContext<RenderableState>>(this.firstPersonPositioning, this.animationDuration));
            }
            if (this.firstPersonPositioningHeavyAttacking == null) {
                this.firstPersonPositioningHeavyAttacking = Collections.singletonList(new Transition<RenderContext<RenderableState>>(this.firstPersonPositioning, this.animationDuration));
            }
            final Iterator<Transition<RenderContext<RenderableState>>> iterator = this.firstPersonPositioningAttacking.iterator();
            Transition<RenderContext<RenderableState>> t = null;
            while (iterator.hasNext()) {
                t = iterator.next();
                this.totalAttackingDuration += t.getDuration();
                this.totalAttackingDuration += t.getPause();
            }
            final Iterator<Transition<RenderContext<RenderableState>>> iterator2 = this.firstPersonPositioningHeavyAttacking.iterator();
            while (iterator2.hasNext()) {
                t = iterator2.next();
                this.totalHeavyAttackingDuration += t.getDuration();
                this.totalHeavyAttackingDuration += t.getPause();
            }
            if (this.firstPersonPositioningRunning == null) {
                this.firstPersonPositioningRunning = this.firstPersonPositioning;
            }
            if (this.firstPersonPositioningModifying == null) {
                this.firstPersonPositioningModifying = this.firstPersonPositioning;
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
            if (this.firstPersonLeftHandPositioningAttacking == null) {
                this.firstPersonLeftHandPositioningAttacking = this.firstPersonPositioningAttacking.stream().map(t -> new Transition(c -> {}, 0L)).collect((Collector<? super Object, ?, List<Transition<RenderContext<RenderableState>>>>)Collectors.toList());
            }
            if (this.firstPersonLeftHandPositioningHeavyAttacking == null) {
                this.firstPersonLeftHandPositioningHeavyAttacking = this.firstPersonPositioningHeavyAttacking.stream().map(t -> new Transition(c -> {}, 0L)).collect((Collector<? super Object, ?, List<Transition<RenderContext<RenderableState>>>>)Collectors.toList());
            }
            if (this.firstPersonRightHandPositioningHeavyAttacking == null) {
                this.firstPersonRightHandPositioningHeavyAttacking = this.firstPersonPositioningHeavyAttacking.stream().map(t -> new Transition(c -> {}, 0L)).collect((Collector<? super Object, ?, List<Transition<RenderContext<RenderableState>>>>)Collectors.toList());
            }
            if (this.firstPersonLeftHandPositioningRunning == null) {
                this.firstPersonLeftHandPositioningRunning = this.firstPersonLeftHandPositioning;
            }
            if (this.firstPersonLeftHandPositioningModifying == null) {
                this.firstPersonLeftHandPositioningModifying = this.firstPersonLeftHandPositioning;
            }
            if (this.firstPersonRightHandPositioning == null) {
                this.firstPersonRightHandPositioning = (context -> {});
            }
            if (this.firstPersonRightHandPositioningAttacking == null) {
                this.firstPersonRightHandPositioningAttacking = this.firstPersonPositioningAttacking.stream().map(t -> new Transition(c -> {}, 0L)).collect((Collector<? super Object, ?, List<Transition<RenderContext<RenderableState>>>>)Collectors.toList());
            }
            if (this.firstPersonRightHandPositioningHeavyAttacking == null) {
                this.firstPersonRightHandPositioningHeavyAttacking = this.firstPersonPositioningHeavyAttacking.stream().map(t -> new Transition(c -> {}, 0L)).collect((Collector<? super Object, ?, List<Transition<RenderContext<RenderableState>>>>)Collectors.toList());
            }
            if (this.firstPersonRightHandPositioningRunning == null) {
                this.firstPersonRightHandPositioningRunning = this.firstPersonRightHandPositioning;
            }
            if (this.firstPersonRightHandPositioningModifying == null) {
                this.firstPersonRightHandPositioningModifying = this.firstPersonRightHandPositioning;
            }
            this.firstPersonCustomPositioningAttacking.forEach((p, t) -> {
                if (t.size() != this.firstPersonPositioningAttacking.size()) {
                    new IllegalStateException("Custom reloading transition number mismatch. Expected " + this.firstPersonPositioningAttacking.size() + ", actual: " + t.size());
                    throw;
                }
                else {
                    return;
                }
            });
            this.firstPersonCustomPositioningHeavyAttacking.forEach((p, t) -> {
                if (t.size() != this.firstPersonPositioningHeavyAttacking.size()) {
                    new IllegalStateException("Custom reloading transition number mismatch. Expected " + this.firstPersonPositioningAttacking.size() + ", actual: " + t.size());
                    throw;
                }
                else {
                    return;
                }
            });
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
        
        private /* synthetic */ void lambda$build$121(final Part p, final List t) {
            if (t.size() != this.firstPersonPositioningHeavyAttacking.size()) {
                throw new IllegalStateException("Custom reloading transition number mismatch. Expected " + this.firstPersonPositioningAttacking.size() + ", actual: " + t.size());
            }
        }
        
        private /* synthetic */ void lambda$build$120(final Part p, final List t) {
            if (t.size() != this.firstPersonPositioningAttacking.size()) {
                throw new IllegalStateException("Custom reloading transition number mismatch. Expected " + this.firstPersonPositioningAttacking.size() + ", actual: " + t.size());
            }
        }
        
        private static /* synthetic */ Transition lambda$build$119(final Transition t) {
            return new Transition(c -> {}, 0L);
        }
        
        private static /* synthetic */ void lambda$null$118(final RenderContext c) {
        }
        
        private static /* synthetic */ Transition lambda$build$117(final Transition t) {
            return new Transition(c -> {}, 0L);
        }
        
        private static /* synthetic */ void lambda$null$116(final RenderContext c) {
        }
        
        private static /* synthetic */ void lambda$build$115(final RenderContext context) {
        }
        
        private static /* synthetic */ Transition lambda$build$114(final Transition t) {
            return new Transition(c -> {}, 0L);
        }
        
        private static /* synthetic */ void lambda$null$113(final RenderContext c) {
        }
        
        private static /* synthetic */ Transition lambda$build$112(final Transition t) {
            return new Transition(c -> {}, 0L);
        }
        
        private static /* synthetic */ void lambda$null$111(final RenderContext c) {
        }
        
        private static /* synthetic */ Transition lambda$build$110(final Transition t) {
            return new Transition(c -> {}, 0L);
        }
        
        private static /* synthetic */ void lambda$null$109(final RenderContext c) {
        }
        
        private static /* synthetic */ void lambda$build$108(final RenderContext context) {
        }
        
        private static /* synthetic */ void lambda$build$107(final RenderContext context) {
            GL11.glTranslatef(-0.4f, 0.2f, 0.4f);
            GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(70.0f, 1.0f, 0.0f, 0.0f);
        }
        
        private static /* synthetic */ void lambda$build$106(final RenderContext renderContext) {
        }
        
        private static /* synthetic */ void lambda$build$105(final ItemStack itemStack) {
        }
        
        private static /* synthetic */ void lambda$build$104(final ItemStack itemStack) {
            GL11.glTranslatef(0.0f, 0.12f, 0.0f);
        }
        
        static /* synthetic */ long access$200(final Builder x0) {
            return x0.totalAttackingDuration;
        }
        
        static /* synthetic */ long access$300(final Builder x0) {
            return x0.totalHeavyAttackingDuration;
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
        
        static /* synthetic */ Consumer access$800(final Builder x0) {
            return x0.firstPersonPositioningModifying;
        }
        
        static /* synthetic */ Consumer access$900(final Builder x0) {
            return x0.firstPersonLeftHandPositioningModifying;
        }
        
        static /* synthetic */ Consumer access$1000(final Builder x0) {
            return x0.firstPersonRightHandPositioningModifying;
        }
        
        static /* synthetic */ LinkedHashMap access$1100(final Builder x0) {
            return x0.firstPersonCustomPositioning;
        }
        
        static /* synthetic */ Consumer access$1300(final Builder x0) {
            return x0.firstPersonLeftHandPositioningRunning;
        }
        
        static /* synthetic */ Consumer access$1400(final Builder x0) {
            return x0.firstPersonRightHandPositioningRunning;
        }
        
        static /* synthetic */ List access$1500(final Builder x0) {
            return x0.firstPersonPositioningAttacking;
        }
        
        static /* synthetic */ List access$1600(final Builder x0) {
            return x0.firstPersonLeftHandPositioningAttacking;
        }
        
        static /* synthetic */ List access$1700(final Builder x0) {
            return x0.firstPersonRightHandPositioningAttacking;
        }
        
        static /* synthetic */ LinkedHashMap access$1800(final Builder x0) {
            return x0.firstPersonCustomPositioningAttacking;
        }
        
        static /* synthetic */ List access$2000(final Builder x0) {
            return x0.firstPersonPositioningHeavyAttacking;
        }
        
        static /* synthetic */ List access$2100(final Builder x0) {
            return x0.firstPersonLeftHandPositioningHeavyAttacking;
        }
        
        static /* synthetic */ List access$2200(final Builder x0) {
            return x0.firstPersonRightHandPositioningHeavyAttacking;
        }
        
        static /* synthetic */ LinkedHashMap access$2300(final Builder x0) {
            return x0.firstPersonCustomPositioningHeavyAttacking;
        }
        
        static /* synthetic */ Consumer access$2400(final Builder x0) {
            return x0.firstPersonPositioning;
        }
        
        static /* synthetic */ Consumer access$2500(final Builder x0) {
            return x0.firstPersonLeftHandPositioning;
        }
        
        static /* synthetic */ Consumer access$2600(final Builder x0) {
            return x0.firstPersonRightHandPositioning;
        }
        
        static /* synthetic */ boolean access$2700(final Builder x0) {
            return x0.hasRecoilPositioningDefined;
        }
        
        static /* synthetic */ BiConsumer access$2800(final Builder x0) {
            return x0.partDebugPositioning;
        }
    }
    
    private class WeaponPositionProvider implements MultipartTransitionProvider<RenderableState, Part, RenderContext<RenderableState>>
    {
        final /* synthetic */ MeleeRenderer this$0;
        
        private WeaponPositionProvider(final MeleeRenderer this$0) {
            this.this$0 = this$0;
            super();
        }
        
        @Override
        public List<MultipartTransition<Part, RenderContext<RenderableState>>> getPositioning(final RenderableState state) {
            switch (state) {
                case MODIFYING: {
                    return MeleeRenderer.this.getSimpleTransition(this.this$0.builder.firstPersonPositioningModifying, this.this$0.builder.firstPersonLeftHandPositioningModifying, this.this$0.builder.firstPersonRightHandPositioningModifying, this.this$0.builder.firstPersonCustomPositioning, this.this$0.builder.animationDuration);
                }
                case RUNNING: {
                    return MeleeRenderer.this.getSimpleTransition(this.this$0.builder.firstPersonPositioningRunning, this.this$0.builder.firstPersonLeftHandPositioningRunning, this.this$0.builder.firstPersonRightHandPositioningRunning, this.this$0.builder.firstPersonCustomPositioning, this.this$0.builder.animationDuration);
                }
                case ATTACKING: {
                    return MeleeRenderer.this.getComplexTransition(this.this$0.builder.firstPersonPositioningAttacking, this.this$0.builder.firstPersonLeftHandPositioningAttacking, this.this$0.builder.firstPersonRightHandPositioningAttacking, this.this$0.builder.firstPersonCustomPositioningAttacking);
                }
                case HEAVY_ATTACKING: {
                    return MeleeRenderer.this.getComplexTransition(this.this$0.builder.firstPersonPositioningHeavyAttacking, this.this$0.builder.firstPersonLeftHandPositioningHeavyAttacking, this.this$0.builder.firstPersonRightHandPositioningHeavyAttacking, this.this$0.builder.firstPersonCustomPositioningHeavyAttacking);
                }
                case NORMAL: {
                    return MeleeRenderer.this.getSimpleTransition(this.this$0.builder.firstPersonPositioning, this.this$0.builder.firstPersonLeftHandPositioning, this.this$0.builder.firstPersonRightHandPositioning, this.this$0.builder.firstPersonCustomPositioning, this.this$0.builder.animationDuration);
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
        
        WeaponPositionProvider(final MeleeRenderer x0, final MeleeRenderer$1 x1) {
            this(x0);
        }
    }
}
