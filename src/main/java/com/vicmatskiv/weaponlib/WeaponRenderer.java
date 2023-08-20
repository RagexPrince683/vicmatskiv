package com.vicmatskiv.weaponlib;

import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import java.util.function.*;
import com.vicmatskiv.weaponlib.animation.*;
import net.minecraft.client.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.model.*;
import org.apache.logging.log4j.*;
import java.util.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import java.util.stream.*;

public class WeaponRenderer extends CompatibleWeaponRenderer
{
    private static final Logger logger;
    private static final float DEFAULT_RANDOMIZING_RATE = 0.33f;
    private static final float DEFAULT_RANDOMIZING_FIRING_RATE = 20.0f;
    private static final float DEFAULT_RANDOMIZING_ZOOM_RATE = 0.25f;
    private static final float DEFAULT_NORMAL_RANDOMIZING_AMPLITUDE = 0.06f;
    private static final float DEFAULT_ZOOM_RANDOMIZING_AMPLITUDE = 0.005f;
    private static final float DEFAULT_FIRING_RANDOMIZING_AMPLITUDE = 0.03f;
    private static final int DEFAULT_ANIMATION_DURATION = 250;
    private static final int DEFAULT_RECOIL_ANIMATION_DURATION = 100;
    private static final int DEFAULT_SHOOTING_ANIMATION_DURATION = 100;
    private Builder builder;
    private Map<EntityPlayer, MultipartRenderStateManager<RenderableState, Part, RenderContext<RenderableState>>> firstPersonStateManagers;
    private MultipartTransitionProvider<RenderableState, Part, RenderContext<RenderableState>> weaponTransitionProvider;
    protected ClientModContext clientModContext;
    
    private WeaponRenderer(final Builder builder) {
        super(builder);
        this.builder = builder;
        this.firstPersonStateManagers = new HashMap<EntityPlayer, MultipartRenderStateManager<RenderableState, Part, RenderContext<RenderableState>>>();
        this.weaponTransitionProvider = new WeaponPositionProvider(this);
    }
    
    protected long getTotalReloadingDuration() {
        return this.builder.totalReloadingDuration;
    }
    
    protected long getTotalUnloadingDuration() {
        return this.builder.totalUnloadingDuration;
    }
    
    @Override
    protected ClientModContext getClientModContext() {
        return this.clientModContext;
    }
    
    protected void setClientModContext(final ClientModContext clientModContext) {
        this.clientModContext = clientModContext;
    }
    
    @Override
    protected StateDescriptor getStateDescriptor(final EntityPlayer player, final ItemStack itemStack) {
        float amplitude = this.builder.normalRandomizingAmplitude;
        float rate = this.builder.normalRandomizingRate;
        RenderableState currentState = null;
        final PlayerItemInstance<?> playerItemInstance = this.clientModContext.getPlayerItemInstanceRegistry().getItemInstance(player, itemStack);
        PlayerWeaponInstance playerWeaponInstance = null;
        if (playerItemInstance == null || !(playerItemInstance instanceof PlayerWeaponInstance) || playerItemInstance.getItem() != itemStack.getItem()) {
            WeaponRenderer.logger.error("Invalid or mismatching item. Player item instance: {}. Item stack: {}", new Object[] { playerItemInstance, itemStack });
        }
        else {
            playerWeaponInstance = (PlayerWeaponInstance)playerItemInstance;
        }
        if (playerWeaponInstance != null) {
            final AsyncWeaponState asyncWeaponState = this.getNextNonExpiredState(playerWeaponInstance);
            switch (asyncWeaponState.getState()) {
                case RECOILED: {
                    if (playerWeaponInstance.isAutomaticModeEnabled() && !this.hasRecoilPositioning()) {
                        if (playerWeaponInstance.isAimed()) {
                            currentState = RenderableState.ZOOMING;
                            rate = this.builder.firingRandomizingRate;
                            amplitude = this.builder.zoomRandomizingAmplitude;
                            break;
                        }
                        currentState = RenderableState.NORMAL;
                        rate = this.builder.firingRandomizingRate;
                        amplitude = this.builder.firingRandomizingAmplitude;
                        break;
                    }
                    else {
                        if (playerWeaponInstance.isAimed()) {
                            currentState = RenderableState.ZOOMING_RECOILED;
                            amplitude = this.builder.zoomRandomizingAmplitude;
                            break;
                        }
                        currentState = RenderableState.RECOILED;
                        break;
                    }
                    break;
                }
                case PAUSED: {
                    if (playerWeaponInstance.isAutomaticModeEnabled() && !this.hasRecoilPositioning()) {
                        final boolean isLongPaused = System.currentTimeMillis() - asyncWeaponState.getTimestamp() > 50.0f / playerWeaponInstance.getFireRate() && asyncWeaponState.isInfinite();
                        if (playerWeaponInstance.isAimed()) {
                            currentState = RenderableState.ZOOMING;
                            if (!isLongPaused) {
                                rate = this.builder.firingRandomizingRate;
                            }
                            amplitude = this.builder.zoomRandomizingAmplitude;
                        }
                        else {
                            currentState = RenderableState.NORMAL;
                            if (!isLongPaused) {
                                rate = this.builder.firingRandomizingRate;
                                amplitude = this.builder.firingRandomizingAmplitude;
                            }
                        }
                        break;
                    }
                    if (playerWeaponInstance.isAimed()) {
                        currentState = RenderableState.ZOOMING_SHOOTING;
                        amplitude = this.builder.zoomRandomizingAmplitude;
                        break;
                    }
                    currentState = RenderableState.SHOOTING;
                    break;
                }
                case UNLOAD_PREPARING:
                case UNLOAD_REQUESTED:
                case UNLOAD: {
                    currentState = RenderableState.UNLOADING;
                    break;
                }
                case LOAD: {
                    currentState = RenderableState.RELOADING;
                    break;
                }
                case EJECTING: {
                    currentState = RenderableState.EJECT_SPENT_ROUND;
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
                    if (playerWeaponInstance.isAimed()) {
                        currentState = RenderableState.ZOOMING;
                        rate = this.builder.zoomRandomizingRate;
                        amplitude = this.builder.zoomRandomizingAmplitude;
                        break;
                    }
                    break;
                }
            }
            WeaponRenderer.logger.trace("Rendering state {} created from {}", new Object[] { currentState, asyncWeaponState.getState() });
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
            stateManager.setState(currentState, true, currentState == RenderableState.SHOOTING || currentState == RenderableState.ZOOMING_SHOOTING);
        }
        return new StateDescriptor(playerWeaponInstance, stateManager, rate, amplitude);
    }
    
    private AsyncWeaponState getNextNonExpiredState(final PlayerWeaponInstance playerWeaponState) {
        AsyncWeaponState asyncWeaponState = null;
        while ((asyncWeaponState = playerWeaponState.nextHistoryState()) != null) {
            if (System.currentTimeMillis() < asyncWeaponState.getTimestamp() + asyncWeaponState.getDuration()) {
                if (asyncWeaponState.getState() != WeaponState.FIRING) {
                    break;
                }
                if (this.hasRecoilPositioning()) {
                    continue;
                }
                if (!playerWeaponState.isAutomaticModeEnabled()) {
                    continue;
                }
                break;
            }
        }
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
                    WeaponRenderer.logger.warn("Transition not defined for part {}", new Object[] { custom });
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
            attachments = ((Weapon)weaponItemStack.getItem()).getActiveAttachments(renderContext.getPlayer(), weaponItemStack);
        }
        if (this.builder.getTextureName() != null) {
            Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(this.builder.getModId() + ":textures/models/" + this.builder.getTextureName()));
        }
        else {
            String textureName = null;
            final CompatibleAttachment<?> compatibleSkin = attachments.stream().filter(ca -> ca.getAttachment() instanceof ItemSkin).findAny().orElse(null);
            if (compatibleSkin != null) {
                final PlayerItemInstance<?> itemInstance = this.getClientModContext().getPlayerItemInstanceRegistry().getItemInstance(renderContext.getPlayer(), weaponItemStack);
                if (itemInstance instanceof PlayerWeaponInstance) {
                    final int textureIndex = ((PlayerWeaponInstance)itemInstance).getActiveTextureIndex();
                    if (textureIndex >= 0) {
                        textureName = ((ItemSkin)compatibleSkin.getAttachment()).getTextureVariant(textureIndex) + ".png";
                    }
                }
            }
            if (textureName == null) {
                final Weapon weapon = (Weapon)weaponItemStack.getItem();
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
    
    private static /* synthetic */ boolean lambda$renderItem$52(final CompatibleAttachment ca) {
        return ca.getAttachment() instanceof ItemSkin;
    }
    
    private /* synthetic */ void lambda$getSimpleTransition$51(final MultipartTransition multipartTransition, final Part part, final Consumer position) {
        multipartTransition.withPartPositionFunction(part, this.createWeaponPartPositionFunction(position));
    }
    
    private static /* synthetic */ void lambda$createWeaponPartPositionFunction$50(final RenderContext context) {
    }
    
    private static /* synthetic */ void lambda$createWeaponPartPositionFunction$49(final Consumer consumer, final RenderContext context) {
        consumer.accept(context);
    }
    
    private static /* synthetic */ void lambda$createWeaponPartPositionFunction$48(final RenderContext context) {
    }
    
    private static /* synthetic */ void lambda$createWeaponPartPositionFunction$47(final Consumer consumer, final RenderContext context) {
        consumer.accept(context);
    }
    
    private static /* synthetic */ void lambda$createWeaponPartPositionFunction$46(final RenderContext context) {
    }
    
    WeaponRenderer(final Builder x0, final WeaponRenderer$1 x1) {
        this(x0);
    }
    
    static /* synthetic */ Builder access$1100(final WeaponRenderer x0) {
        return x0.builder;
    }
    
    static /* synthetic */ List access$1600(final WeaponRenderer x0, final Consumer x1, final Consumer x2, final Consumer x3, final LinkedHashMap x4, final int x5) {
        return x0.getSimpleTransition(x1, x2, x3, x4, x5);
    }
    
    static /* synthetic */ List access$2300(final WeaponRenderer x0, final List x1, final List x2, final List x3, final LinkedHashMap x4) {
        return x0.getComplexTransition(x1, x2, x3, x4);
    }
    
    static {
        logger = LogManager.getLogger((Class)WeaponRenderer.class);
    }
    
    public static class Builder
    {
        private ModelBase model;
        private String textureName;
        private float weaponProximity;
        private float yOffsetZoom;
        private float xOffsetZoom;
        private Consumer<ItemStack> entityPositioning;
        private Consumer<ItemStack> inventoryPositioning;
        private Consumer<RenderContext<RenderableState>> thirdPersonPositioning;
        private Consumer<RenderContext<RenderableState>> firstPersonPositioning;
        private Consumer<RenderContext<RenderableState>> firstPersonPositioningZooming;
        private Consumer<RenderContext<RenderableState>> firstPersonPositioningRunning;
        private Consumer<RenderContext<RenderableState>> firstPersonPositioningModifying;
        private Consumer<RenderContext<RenderableState>> firstPersonPositioningRecoiled;
        private Consumer<RenderContext<RenderableState>> firstPersonPositioningShooting;
        private Consumer<RenderContext<RenderableState>> firstPersonPositioningZoomingRecoiled;
        private Consumer<RenderContext<RenderableState>> firstPersonPositioningZoomingShooting;
        private Consumer<RenderContext<RenderableState>> firstPersonLeftHandPositioning;
        private Consumer<RenderContext<RenderableState>> firstPersonLeftHandPositioningZooming;
        private Consumer<RenderContext<RenderableState>> firstPersonLeftHandPositioningRunning;
        private Consumer<RenderContext<RenderableState>> firstPersonLeftHandPositioningModifying;
        private Consumer<RenderContext<RenderableState>> firstPersonLeftHandPositioningRecoiled;
        private Consumer<RenderContext<RenderableState>> firstPersonLeftHandPositioningShooting;
        private Consumer<RenderContext<RenderableState>> firstPersonRightHandPositioning;
        private Consumer<RenderContext<RenderableState>> firstPersonRightHandPositioningZooming;
        private Consumer<RenderContext<RenderableState>> firstPersonRightHandPositioningRunning;
        private Consumer<RenderContext<RenderableState>> firstPersonRightHandPositioningModifying;
        private Consumer<RenderContext<RenderableState>> firstPersonRightHandPositioningRecoiled;
        private Consumer<RenderContext<RenderableState>> firstPersonRightHandPositioningShooting;
        private List<Transition<RenderContext<RenderableState>>> firstPersonPositioningReloading;
        private List<Transition<RenderContext<RenderableState>>> firstPersonLeftHandPositioningReloading;
        private List<Transition<RenderContext<RenderableState>>> firstPersonRightHandPositioningReloading;
        private List<Transition<RenderContext<RenderableState>>> firstPersonPositioningUnloading;
        private List<Transition<RenderContext<RenderableState>>> firstPersonLeftHandPositioningUnloading;
        private List<Transition<RenderContext<RenderableState>>> firstPersonRightHandPositioningUnloading;
        private long totalReloadingDuration;
        private long totalUnloadingDuration;
        private String modId;
        private int recoilAnimationDuration;
        private int shootingAnimationDuration;
        private float normalRandomizingRate;
        private float firingRandomizingRate;
        private float zoomRandomizingRate;
        private float normalRandomizingAmplitude;
        private float zoomRandomizingAmplitude;
        private float firingRandomizingAmplitude;
        private LinkedHashMap<Part, Consumer<RenderContext<RenderableState>>> firstPersonCustomPositioning;
        private LinkedHashMap<Part, List<Transition<RenderContext<RenderableState>>>> firstPersonCustomPositioningUnloading;
        private LinkedHashMap<Part, List<Transition<RenderContext<RenderableState>>>> firstPersonCustomPositioningReloading;
        private LinkedHashMap<Part, Consumer<RenderContext<RenderableState>>> firstPersonCustomPositioningRecoiled;
        private LinkedHashMap<Part, Consumer<RenderContext<RenderableState>>> firstPersonCustomPositioningZoomingRecoiled;
        private LinkedHashMap<Part, Consumer<RenderContext<RenderableState>>> firstPersonCustomPositioningZoomingShooting;
        private List<Transition<RenderContext<RenderableState>>> firstPersonPositioningEjectSpentRound;
        private List<Transition<RenderContext<RenderableState>>> firstPersonLeftHandPositioningEjectSpentRound;
        private List<Transition<RenderContext<RenderableState>>> firstPersonRightHandPositioningEjectSpentRound;
        private LinkedHashMap<Part, List<Transition<RenderContext<RenderableState>>>> firstPersonCustomPositioningEjectSpentRound;
        private boolean hasRecoilPositioningDefined;
        
        public Builder() {
            super();
            this.xOffsetZoom = 0.69f;
            this.recoilAnimationDuration = 100;
            this.shootingAnimationDuration = 100;
            this.normalRandomizingRate = 0.33f;
            this.firingRandomizingRate = 20.0f;
            this.zoomRandomizingRate = 0.25f;
            this.normalRandomizingAmplitude = 0.06f;
            this.zoomRandomizingAmplitude = 0.005f;
            this.firingRandomizingAmplitude = 0.03f;
            this.firstPersonCustomPositioning = new LinkedHashMap<Part, Consumer<RenderContext<RenderableState>>>();
            this.firstPersonCustomPositioningUnloading = new LinkedHashMap<Part, List<Transition<RenderContext<RenderableState>>>>();
            this.firstPersonCustomPositioningReloading = new LinkedHashMap<Part, List<Transition<RenderContext<RenderableState>>>>();
            this.firstPersonCustomPositioningRecoiled = new LinkedHashMap<Part, Consumer<RenderContext<RenderableState>>>();
            this.firstPersonCustomPositioningZoomingRecoiled = new LinkedHashMap<Part, Consumer<RenderContext<RenderableState>>>();
            this.firstPersonCustomPositioningZoomingShooting = new LinkedHashMap<Part, Consumer<RenderContext<RenderableState>>>();
            this.firstPersonCustomPositioningEjectSpentRound = new LinkedHashMap<Part, List<Transition<RenderContext<RenderableState>>>>();
        }
        
        public Builder withModId(final String modId) {
            this.modId = modId;
            return this;
        }
        
        public Builder withModel(final ModelBase model) {
            this.model = model;
            return this;
        }
        
        public Builder withShootingAnimationDuration(final int shootingAnimationDuration) {
            this.shootingAnimationDuration = shootingAnimationDuration;
            return this;
        }
        
        public Builder withRecoilAnimationDuration(final int recoilAnimationDuration) {
            this.recoilAnimationDuration = recoilAnimationDuration;
            return this;
        }
        
        public Builder withNormalRandomizingRate(final float normalRandomizingRate) {
            this.normalRandomizingRate = normalRandomizingRate;
            return this;
        }
        
        public Builder withZoomRandomizingRate(final float zoomRandomizingRate) {
            this.zoomRandomizingRate = zoomRandomizingRate;
            return this;
        }
        
        public Builder withFiringRandomizingRate(final float firingRandomizingRate) {
            this.firingRandomizingRate = firingRandomizingRate;
            return this;
        }
        
        public Builder withFiringRandomizingAmplitude(final float firingRandomizingAmplitude) {
            this.firingRandomizingAmplitude = firingRandomizingAmplitude;
            return this;
        }
        
        public Builder withNormalRandomizingAmplitude(final float firingRandomizingRate) {
            this.firingRandomizingRate = firingRandomizingRate;
            return this;
        }
        
        public Builder withZoomRandomizingAmplitude(final float zoomRandomizingAmplitude) {
            this.zoomRandomizingAmplitude = zoomRandomizingAmplitude;
            return this;
        }
        
        public Builder withTextureName(final String textureName) {
            this.textureName = textureName + ".png";
            return this;
        }
        
        public Builder withWeaponProximity(final float weaponProximity) {
            this.weaponProximity = weaponProximity;
            return this;
        }
        
        public Builder withYOffsetZoom(final float yOffsetZoom) {
            this.yOffsetZoom = yOffsetZoom;
            return this;
        }
        
        public Builder withXOffsetZoom(final float xOffsetZoom) {
            this.xOffsetZoom = xOffsetZoom;
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
        
        public Builder withFirstPersonPositioningZooming(final Consumer<RenderContext<RenderableState>> firstPersonPositioningZooming) {
            this.firstPersonPositioningZooming = firstPersonPositioningZooming;
            return this;
        }
        
        public Builder withFirstPersonPositioningRecoiled(final Consumer<RenderContext<RenderableState>> firstPersonPositioningRecoiled) {
            this.hasRecoilPositioningDefined = true;
            this.firstPersonPositioningRecoiled = firstPersonPositioningRecoiled;
            return this;
        }
        
        public Builder withFirstPersonPositioningShooting(final Consumer<RenderContext<RenderableState>> firstPersonPositioningShooting) {
            this.firstPersonPositioningShooting = firstPersonPositioningShooting;
            return this;
        }
        
        public Builder withFirstPersonPositioningZoomingRecoiled(final Consumer<RenderContext<RenderableState>> firstPersonPositioningZoomingRecoiled) {
            this.firstPersonPositioningZoomingRecoiled = firstPersonPositioningZoomingRecoiled;
            return this;
        }
        
        public Builder withFirstPersonPositioningZoomingShooting(final Consumer<RenderContext<RenderableState>> firstPersonPositioningZoomingShooting) {
            this.firstPersonPositioningZoomingShooting = firstPersonPositioningZoomingShooting;
            return this;
        }
        
        @SafeVarargs
        public final Builder withFirstPersonPositioningReloading(final Transition<RenderContext<RenderableState>>... transitions) {
            this.firstPersonPositioningReloading = Arrays.asList(transitions);
            return this;
        }
        
        @SafeVarargs
        public final Builder withFirstPersonPositioningUnloading(final Transition<RenderContext<RenderableState>>... transitions) {
            this.firstPersonPositioningUnloading = Arrays.asList(transitions);
            return this;
        }
        
        @SafeVarargs
        public final Builder withFirstPersonPositioningEjectSpentRound(final Transition<RenderContext<RenderableState>>... transitions) {
            this.firstPersonPositioningEjectSpentRound = Arrays.asList(transitions);
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
        
        public Builder withFirstPersonHandPositioningZooming(final Consumer<RenderContext<RenderableState>> leftHand, final Consumer<RenderContext<RenderableState>> rightHand) {
            this.firstPersonLeftHandPositioningZooming = leftHand;
            this.firstPersonRightHandPositioningZooming = rightHand;
            return this;
        }
        
        public Builder withFirstPersonHandPositioningRecoiled(final Consumer<RenderContext<RenderableState>> leftHand, final Consumer<RenderContext<RenderableState>> rightHand) {
            this.firstPersonLeftHandPositioningRecoiled = leftHand;
            this.firstPersonRightHandPositioningRecoiled = rightHand;
            return this;
        }
        
        public Builder withFirstPersonHandPositioningShooting(final Consumer<RenderContext<RenderableState>> leftHand, final Consumer<RenderContext<RenderableState>> rightHand) {
            this.firstPersonLeftHandPositioningShooting = leftHand;
            this.firstPersonRightHandPositioningShooting = rightHand;
            return this;
        }
        
        @SafeVarargs
        public final Builder withFirstPersonLeftHandPositioningReloading(final Transition<RenderContext<RenderableState>>... transitions) {
            this.firstPersonLeftHandPositioningReloading = Arrays.asList(transitions);
            return this;
        }
        
        @SafeVarargs
        public final Builder withFirstPersonLeftHandPositioningEjectSpentRound(final Transition<RenderContext<RenderableState>>... transitions) {
            this.firstPersonLeftHandPositioningEjectSpentRound = Arrays.asList(transitions);
            return this;
        }
        
        @SafeVarargs
        public final Builder withFirstPersonLeftHandPositioningUnloading(final Transition<RenderContext<RenderableState>>... transitions) {
            this.firstPersonLeftHandPositioningUnloading = Arrays.asList(transitions);
            return this;
        }
        
        @SafeVarargs
        public final Builder withFirstPersonRightHandPositioningReloading(final Transition<RenderContext<RenderableState>>... transitions) {
            this.firstPersonRightHandPositioningReloading = Arrays.asList(transitions);
            return this;
        }
        
        @SafeVarargs
        public final Builder withFirstPersonRightHandPositioningUnloading(final Transition<RenderContext<RenderableState>>... transitions) {
            this.firstPersonRightHandPositioningUnloading = Arrays.asList(transitions);
            return this;
        }
        
        @SafeVarargs
        public final Builder withFirstPersonRightHandPositioningEjectSpentRound(final Transition<RenderContext<RenderableState>>... transitions) {
            this.firstPersonRightHandPositioningEjectSpentRound = Arrays.asList(transitions);
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
        
        public Builder withFirstPersonPositioningCustomRecoiled(final Part part, final Consumer<RenderContext<RenderableState>> positioning) {
            if (part instanceof DefaultPart) {
                throw new IllegalArgumentException("Part " + part + " is not custom");
            }
            if (this.firstPersonCustomPositioningRecoiled.put(part, positioning) != null) {
                throw new IllegalArgumentException("Part " + part + " already added");
            }
            return this;
        }
        
        public Builder withFirstPersonPositioningCustomZoomingShooting(final Part part, final Consumer<RenderContext<RenderableState>> positioning) {
            if (part instanceof DefaultPart) {
                throw new IllegalArgumentException("Part " + part + " is not custom");
            }
            if (this.firstPersonCustomPositioningZoomingShooting.put(part, positioning) != null) {
                throw new IllegalArgumentException("Part " + part + " already added");
            }
            return this;
        }
        
        public Builder withFirstPersonPositioningCustomZoomingRecoiled(final Part part, final Consumer<RenderContext<RenderableState>> positioning) {
            if (part instanceof DefaultPart) {
                throw new IllegalArgumentException("Part " + part + " is not custom");
            }
            if (this.firstPersonCustomPositioningZoomingRecoiled.put(part, positioning) != null) {
                throw new IllegalArgumentException("Part " + part + " already added");
            }
            return this;
        }
        
        @SafeVarargs
        public final Builder withFirstPersonCustomPositioningReloading(final Part part, final Transition<RenderContext<RenderableState>>... transitions) {
            if (part instanceof DefaultPart) {
                throw new IllegalArgumentException("Part " + part + " is not custom");
            }
            this.firstPersonCustomPositioningReloading.put(part, Arrays.asList(transitions));
            return this;
        }
        
        @SafeVarargs
        public final Builder withFirstPersonCustomPositioningUnloading(final Part part, final Transition<RenderContext<RenderableState>>... transitions) {
            if (part instanceof DefaultPart) {
                throw new IllegalArgumentException("Part " + part + " is not custom");
            }
            this.firstPersonCustomPositioningUnloading.put(part, Arrays.asList(transitions));
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
        
        public WeaponRenderer build() {
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
            final WeaponRenderer renderer = new WeaponRenderer(this, null);
            if (this.firstPersonPositioning == null) {
                this.firstPersonPositioning = (renderContext -> {
                    GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
                    if (weaponRenderer.getClientModContext() != null) {
                        final PlayerWeaponInstance instance = weaponRenderer.getClientModContext().getMainHeldWeapon();
                        if (instance != null && instance.isAimed()) {
                            GL11.glTranslatef(this.xOffsetZoom, this.yOffsetZoom, this.weaponProximity);
                        }
                        else {
                            GL11.glTranslatef(0.0f, -1.2f, 0.0f);
                        }
                    }
                    return;
                });
            }
            if (this.firstPersonPositioningZooming == null) {
                this.firstPersonPositioningZooming = this.firstPersonPositioning;
            }
            if (this.firstPersonPositioningReloading == null) {
                this.firstPersonPositioningReloading = Collections.singletonList(new Transition<RenderContext<RenderableState>>(this.firstPersonPositioning, 250L));
            }
            final Iterator<Transition<RenderContext<RenderableState>>> iterator = this.firstPersonPositioningReloading.iterator();
            Transition<RenderContext<RenderableState>> t = null;
            while (iterator.hasNext()) {
                t = iterator.next();
                this.totalReloadingDuration += t.getDuration();
                this.totalReloadingDuration += t.getPause();
            }
            if (this.firstPersonPositioningUnloading == null) {
                this.firstPersonPositioningUnloading = Collections.singletonList(new Transition<RenderContext<RenderableState>>(this.firstPersonPositioning, 250L));
            }
            final Iterator<Transition<RenderContext<RenderableState>>> iterator2 = this.firstPersonPositioningUnloading.iterator();
            while (iterator2.hasNext()) {
                t = iterator2.next();
                this.totalUnloadingDuration += t.getDuration();
                this.totalUnloadingDuration += t.getPause();
            }
            if (this.firstPersonPositioningRecoiled == null) {
                this.firstPersonPositioningRecoiled = this.firstPersonPositioning;
            }
            if (this.firstPersonPositioningRunning == null) {
                this.firstPersonPositioningRunning = this.firstPersonPositioning;
            }
            if (this.firstPersonPositioningModifying == null) {
                this.firstPersonPositioningModifying = this.firstPersonPositioning;
            }
            if (this.firstPersonPositioningShooting == null) {
                this.firstPersonPositioningShooting = this.firstPersonPositioning;
            }
            if (this.firstPersonPositioningZoomingRecoiled == null) {
                this.firstPersonPositioningZoomingRecoiled = this.firstPersonPositioningZooming;
            }
            if (this.firstPersonPositioningZoomingShooting == null) {
                this.firstPersonPositioningZoomingShooting = this.firstPersonPositioningZooming;
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
            if (this.firstPersonLeftHandPositioningReloading == null) {
                this.firstPersonLeftHandPositioningReloading = this.firstPersonPositioningReloading.stream().map(t -> new Transition(c -> {}, 0L)).collect((Collector<? super Object, ?, List<Transition<RenderContext<RenderableState>>>>)Collectors.toList());
            }
            if (this.firstPersonLeftHandPositioningUnloading == null) {
                this.firstPersonLeftHandPositioningUnloading = this.firstPersonPositioningUnloading.stream().map(t -> new Transition(c -> {}, 0L)).collect((Collector<? super Object, ?, List<Transition<RenderContext<RenderableState>>>>)Collectors.toList());
            }
            if (this.firstPersonLeftHandPositioningRecoiled == null) {
                this.firstPersonLeftHandPositioningRecoiled = this.firstPersonLeftHandPositioning;
            }
            if (this.firstPersonLeftHandPositioningShooting == null) {
                this.firstPersonLeftHandPositioningShooting = this.firstPersonLeftHandPositioning;
            }
            if (this.firstPersonLeftHandPositioningZooming == null) {
                this.firstPersonLeftHandPositioningZooming = this.firstPersonLeftHandPositioning;
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
            if (this.firstPersonRightHandPositioningReloading == null) {
                this.firstPersonRightHandPositioningReloading = this.firstPersonPositioningReloading.stream().map(t -> new Transition(c -> {}, 0L)).collect((Collector<? super Object, ?, List<Transition<RenderContext<RenderableState>>>>)Collectors.toList());
            }
            if (this.firstPersonRightHandPositioningUnloading == null) {
                this.firstPersonRightHandPositioningUnloading = this.firstPersonPositioningUnloading.stream().map(t -> new Transition(c -> {}, 0L)).collect((Collector<? super Object, ?, List<Transition<RenderContext<RenderableState>>>>)Collectors.toList());
            }
            if (this.firstPersonRightHandPositioningRecoiled == null) {
                this.firstPersonRightHandPositioningRecoiled = this.firstPersonRightHandPositioning;
            }
            if (this.firstPersonRightHandPositioningShooting == null) {
                this.firstPersonRightHandPositioningShooting = this.firstPersonRightHandPositioning;
            }
            if (this.firstPersonRightHandPositioningZooming == null) {
                this.firstPersonRightHandPositioningZooming = this.firstPersonRightHandPositioning;
            }
            if (this.firstPersonRightHandPositioningRunning == null) {
                this.firstPersonRightHandPositioningRunning = this.firstPersonRightHandPositioning;
            }
            if (this.firstPersonRightHandPositioningModifying == null) {
                this.firstPersonRightHandPositioningModifying = this.firstPersonRightHandPositioning;
            }
            if (!this.firstPersonCustomPositioning.isEmpty() && this.firstPersonCustomPositioningRecoiled.isEmpty()) {
                this.firstPersonCustomPositioning.forEach((part, pos) -> this.firstPersonCustomPositioningRecoiled.put(part, pos));
            }
            if (!this.firstPersonCustomPositioning.isEmpty() && this.firstPersonCustomPositioningZoomingRecoiled.isEmpty()) {
                this.firstPersonCustomPositioning.forEach((part, pos) -> this.firstPersonCustomPositioningZoomingRecoiled.put(part, pos));
            }
            if (!this.firstPersonCustomPositioning.isEmpty() && this.firstPersonCustomPositioningZoomingShooting.isEmpty()) {
                this.firstPersonCustomPositioning.forEach((part, pos) -> this.firstPersonCustomPositioningZoomingShooting.put(part, pos));
            }
            this.firstPersonCustomPositioningReloading.forEach((p, t) -> {
                if (t.size() != this.firstPersonPositioningReloading.size()) {
                    new IllegalStateException("Custom reloading transition number mismatch. Expected " + this.firstPersonPositioningReloading.size() + ", actual: " + t.size());
                    throw;
                }
                else {
                    return;
                }
            });
            this.firstPersonCustomPositioningUnloading.forEach((p, t) -> {
                if (t.size() != this.firstPersonPositioningUnloading.size()) {
                    new IllegalStateException("Custom unloading transition number mismatch. Expected " + this.firstPersonPositioningUnloading.size() + ", actual: " + t.size());
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
        
        private /* synthetic */ void lambda$build$45(final Part p, final List t) {
            if (t.size() != this.firstPersonPositioningUnloading.size()) {
                throw new IllegalStateException("Custom unloading transition number mismatch. Expected " + this.firstPersonPositioningUnloading.size() + ", actual: " + t.size());
            }
        }
        
        private /* synthetic */ void lambda$build$44(final Part p, final List t) {
            if (t.size() != this.firstPersonPositioningReloading.size()) {
                throw new IllegalStateException("Custom reloading transition number mismatch. Expected " + this.firstPersonPositioningReloading.size() + ", actual: " + t.size());
            }
        }
        
        private /* synthetic */ void lambda$build$43(final Part part, final Consumer pos) {
            this.firstPersonCustomPositioningZoomingShooting.put(part, pos);
        }
        
        private /* synthetic */ void lambda$build$42(final Part part, final Consumer pos) {
            this.firstPersonCustomPositioningZoomingRecoiled.put(part, pos);
        }
        
        private /* synthetic */ void lambda$build$41(final Part part, final Consumer pos) {
            this.firstPersonCustomPositioningRecoiled.put(part, pos);
        }
        
        private static /* synthetic */ Transition lambda$build$40(final Transition t) {
            return new Transition(c -> {}, 0L);
        }
        
        private static /* synthetic */ void lambda$null$39(final RenderContext c) {
        }
        
        private static /* synthetic */ Transition lambda$build$38(final Transition t) {
            return new Transition(c -> {}, 0L);
        }
        
        private static /* synthetic */ void lambda$null$37(final RenderContext c) {
        }
        
        private static /* synthetic */ void lambda$build$36(final RenderContext context) {
        }
        
        private static /* synthetic */ Transition lambda$build$35(final Transition t) {
            return new Transition(c -> {}, 0L);
        }
        
        private static /* synthetic */ void lambda$null$34(final RenderContext c) {
        }
        
        private static /* synthetic */ Transition lambda$build$33(final Transition t) {
            return new Transition(c -> {}, 0L);
        }
        
        private static /* synthetic */ void lambda$null$32(final RenderContext c) {
        }
        
        private static /* synthetic */ void lambda$build$31(final RenderContext context) {
        }
        
        private static /* synthetic */ void lambda$build$30(final RenderContext context) {
            GL11.glTranslatef(-0.4f, 0.2f, 0.4f);
            GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(70.0f, 1.0f, 0.0f, 0.0f);
        }
        
        private /* synthetic */ void lambda$build$29(final WeaponRenderer weaponRenderer, final RenderContext renderContext) {
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            if (weaponRenderer.getClientModContext() != null) {
                final PlayerWeaponInstance instance = weaponRenderer.getClientModContext().getMainHeldWeapon();
                if (instance != null && instance.isAimed()) {
                    GL11.glTranslatef(this.xOffsetZoom, this.yOffsetZoom, this.weaponProximity);
                }
                else {
                    GL11.glTranslatef(0.0f, -1.2f, 0.0f);
                }
            }
        }
        
        private static /* synthetic */ void lambda$build$28(final ItemStack itemStack) {
        }
        
        private static /* synthetic */ void lambda$build$27(final ItemStack itemStack) {
            GL11.glTranslatef(0.0f, 0.12f, 0.0f);
        }
        
        static /* synthetic */ long access$200(final Builder x0) {
            return x0.totalReloadingDuration;
        }
        
        static /* synthetic */ long access$300(final Builder x0) {
            return x0.totalUnloadingDuration;
        }
        
        static /* synthetic */ float access$400(final Builder x0) {
            return x0.normalRandomizingAmplitude;
        }
        
        static /* synthetic */ float access$500(final Builder x0) {
            return x0.normalRandomizingRate;
        }
        
        static /* synthetic */ float access$600(final Builder x0) {
            return x0.firingRandomizingRate;
        }
        
        static /* synthetic */ float access$700(final Builder x0) {
            return x0.zoomRandomizingAmplitude;
        }
        
        static /* synthetic */ float access$800(final Builder x0) {
            return x0.firingRandomizingAmplitude;
        }
        
        static /* synthetic */ Consumer access$900(final Builder x0) {
            return x0.firstPersonPositioningRunning;
        }
        
        static /* synthetic */ float access$1000(final Builder x0) {
            return x0.zoomRandomizingRate;
        }
        
        static /* synthetic */ Consumer access$1200(final Builder x0) {
            return x0.firstPersonPositioningModifying;
        }
        
        static /* synthetic */ Consumer access$1300(final Builder x0) {
            return x0.firstPersonLeftHandPositioningModifying;
        }
        
        static /* synthetic */ Consumer access$1400(final Builder x0) {
            return x0.firstPersonRightHandPositioningModifying;
        }
        
        static /* synthetic */ LinkedHashMap access$1500(final Builder x0) {
            return x0.firstPersonCustomPositioning;
        }
        
        static /* synthetic */ Consumer access$1700(final Builder x0) {
            return x0.firstPersonLeftHandPositioningRunning;
        }
        
        static /* synthetic */ Consumer access$1800(final Builder x0) {
            return x0.firstPersonRightHandPositioningRunning;
        }
        
        static /* synthetic */ List access$1900(final Builder x0) {
            return x0.firstPersonPositioningUnloading;
        }
        
        static /* synthetic */ List access$2000(final Builder x0) {
            return x0.firstPersonLeftHandPositioningUnloading;
        }
        
        static /* synthetic */ List access$2100(final Builder x0) {
            return x0.firstPersonRightHandPositioningUnloading;
        }
        
        static /* synthetic */ LinkedHashMap access$2200(final Builder x0) {
            return x0.firstPersonCustomPositioningUnloading;
        }
        
        static /* synthetic */ List access$2400(final Builder x0) {
            return x0.firstPersonPositioningReloading;
        }
        
        static /* synthetic */ List access$2500(final Builder x0) {
            return x0.firstPersonLeftHandPositioningReloading;
        }
        
        static /* synthetic */ List access$2600(final Builder x0) {
            return x0.firstPersonRightHandPositioningReloading;
        }
        
        static /* synthetic */ LinkedHashMap access$2700(final Builder x0) {
            return x0.firstPersonCustomPositioningReloading;
        }
        
        static /* synthetic */ Consumer access$2800(final Builder x0) {
            return x0.firstPersonPositioningRecoiled;
        }
        
        static /* synthetic */ Consumer access$2900(final Builder x0) {
            return x0.firstPersonLeftHandPositioningRecoiled;
        }
        
        static /* synthetic */ Consumer access$3000(final Builder x0) {
            return x0.firstPersonRightHandPositioningRecoiled;
        }
        
        static /* synthetic */ LinkedHashMap access$3100(final Builder x0) {
            return x0.firstPersonCustomPositioningRecoiled;
        }
        
        static /* synthetic */ int access$3200(final Builder x0) {
            return x0.recoilAnimationDuration;
        }
        
        static /* synthetic */ Consumer access$3300(final Builder x0) {
            return x0.firstPersonPositioningShooting;
        }
        
        static /* synthetic */ Consumer access$3400(final Builder x0) {
            return x0.firstPersonLeftHandPositioningShooting;
        }
        
        static /* synthetic */ Consumer access$3500(final Builder x0) {
            return x0.firstPersonRightHandPositioningShooting;
        }
        
        static /* synthetic */ int access$3600(final Builder x0) {
            return x0.shootingAnimationDuration;
        }
        
        static /* synthetic */ List access$3700(final Builder x0) {
            return x0.firstPersonPositioningEjectSpentRound;
        }
        
        static /* synthetic */ List access$3800(final Builder x0) {
            return x0.firstPersonLeftHandPositioningEjectSpentRound;
        }
        
        static /* synthetic */ List access$3900(final Builder x0) {
            return x0.firstPersonRightHandPositioningEjectSpentRound;
        }
        
        static /* synthetic */ LinkedHashMap access$4000(final Builder x0) {
            return x0.firstPersonCustomPositioningEjectSpentRound;
        }
        
        static /* synthetic */ Consumer access$4100(final Builder x0) {
            return x0.firstPersonPositioning;
        }
        
        static /* synthetic */ Consumer access$4200(final Builder x0) {
            return x0.firstPersonLeftHandPositioning;
        }
        
        static /* synthetic */ Consumer access$4300(final Builder x0) {
            return x0.firstPersonRightHandPositioning;
        }
        
        static /* synthetic */ Consumer access$4400(final Builder x0) {
            return x0.firstPersonPositioningZooming;
        }
        
        static /* synthetic */ Consumer access$4500(final Builder x0) {
            return x0.firstPersonLeftHandPositioningZooming;
        }
        
        static /* synthetic */ Consumer access$4600(final Builder x0) {
            return x0.firstPersonRightHandPositioningZooming;
        }
        
        static /* synthetic */ Consumer access$4700(final Builder x0) {
            return x0.firstPersonPositioningZoomingShooting;
        }
        
        static /* synthetic */ LinkedHashMap access$4800(final Builder x0) {
            return x0.firstPersonCustomPositioningZoomingShooting;
        }
        
        static /* synthetic */ Consumer access$4900(final Builder x0) {
            return x0.firstPersonPositioningZoomingRecoiled;
        }
        
        static /* synthetic */ LinkedHashMap access$5000(final Builder x0) {
            return x0.firstPersonCustomPositioningZoomingRecoiled;
        }
        
        static /* synthetic */ boolean access$5100(final Builder x0) {
            return x0.hasRecoilPositioningDefined;
        }
    }
    
    private class WeaponPositionProvider implements MultipartTransitionProvider<RenderableState, Part, RenderContext<RenderableState>>
    {
        final /* synthetic */ WeaponRenderer this$0;
        
        private WeaponPositionProvider(final WeaponRenderer this$0) {
            this.this$0 = this$0;
            super();
        }
        
        @Override
        public List<MultipartTransition<Part, RenderContext<RenderableState>>> getPositioning(final RenderableState state) {
            switch (state) {
                case MODIFYING: {
                    return WeaponRenderer.this.getSimpleTransition(this.this$0.builder.firstPersonPositioningModifying, this.this$0.builder.firstPersonLeftHandPositioningModifying, this.this$0.builder.firstPersonRightHandPositioningModifying, this.this$0.builder.firstPersonCustomPositioning, 250);
                }
                case RUNNING: {
                    return WeaponRenderer.this.getSimpleTransition(this.this$0.builder.firstPersonPositioningRunning, this.this$0.builder.firstPersonLeftHandPositioningRunning, this.this$0.builder.firstPersonRightHandPositioningRunning, this.this$0.builder.firstPersonCustomPositioning, 250);
                }
                case UNLOADING: {
                    return WeaponRenderer.this.getComplexTransition(this.this$0.builder.firstPersonPositioningUnloading, this.this$0.builder.firstPersonLeftHandPositioningUnloading, this.this$0.builder.firstPersonRightHandPositioningUnloading, this.this$0.builder.firstPersonCustomPositioningUnloading);
                }
                case RELOADING: {
                    return WeaponRenderer.this.getComplexTransition(this.this$0.builder.firstPersonPositioningReloading, this.this$0.builder.firstPersonLeftHandPositioningReloading, this.this$0.builder.firstPersonRightHandPositioningReloading, this.this$0.builder.firstPersonCustomPositioningReloading);
                }
                case RECOILED: {
                    return WeaponRenderer.this.getSimpleTransition(this.this$0.builder.firstPersonPositioningRecoiled, this.this$0.builder.firstPersonLeftHandPositioningRecoiled, this.this$0.builder.firstPersonRightHandPositioningRecoiled, this.this$0.builder.firstPersonCustomPositioningRecoiled, this.this$0.builder.recoilAnimationDuration);
                }
                case SHOOTING: {
                    return WeaponRenderer.this.getSimpleTransition(this.this$0.builder.firstPersonPositioningShooting, this.this$0.builder.firstPersonLeftHandPositioningShooting, this.this$0.builder.firstPersonRightHandPositioningShooting, this.this$0.builder.firstPersonCustomPositioning, this.this$0.builder.shootingAnimationDuration);
                }
                case EJECT_SPENT_ROUND: {
                    return WeaponRenderer.this.getComplexTransition(this.this$0.builder.firstPersonPositioningEjectSpentRound, this.this$0.builder.firstPersonLeftHandPositioningEjectSpentRound, this.this$0.builder.firstPersonRightHandPositioningEjectSpentRound, this.this$0.builder.firstPersonCustomPositioningEjectSpentRound);
                }
                case NORMAL: {
                    return WeaponRenderer.this.getSimpleTransition(this.this$0.builder.firstPersonPositioning, this.this$0.builder.firstPersonLeftHandPositioning, this.this$0.builder.firstPersonRightHandPositioning, this.this$0.builder.firstPersonCustomPositioning, 250);
                }
                case ZOOMING: {
                    return WeaponRenderer.this.getSimpleTransition(this.this$0.builder.firstPersonPositioningZooming, this.this$0.builder.firstPersonLeftHandPositioningZooming, this.this$0.builder.firstPersonRightHandPositioningZooming, this.this$0.builder.firstPersonCustomPositioning, 250);
                }
                case ZOOMING_SHOOTING: {
                    return WeaponRenderer.this.getSimpleTransition(this.this$0.builder.firstPersonPositioningZoomingShooting, this.this$0.builder.firstPersonLeftHandPositioningZooming, this.this$0.builder.firstPersonRightHandPositioningZooming, this.this$0.builder.firstPersonCustomPositioningZoomingShooting, 60);
                }
                case ZOOMING_RECOILED: {
                    return WeaponRenderer.this.getSimpleTransition(this.this$0.builder.firstPersonPositioningZoomingRecoiled, this.this$0.builder.firstPersonLeftHandPositioningZooming, this.this$0.builder.firstPersonRightHandPositioningZooming, this.this$0.builder.firstPersonCustomPositioningZoomingRecoiled, 60);
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
        
        WeaponPositionProvider(final WeaponRenderer x0, final WeaponRenderer$1 x1) {
            this(x0);
        }
    }
}
