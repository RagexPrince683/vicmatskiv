package com.vicmatskiv.weaponlib;

import net.minecraft.client.model.*;
import java.util.function.*;
import net.minecraft.item.*;
import com.vicmatskiv.weaponlib.animation.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import org.lwjgl.opengl.*;
import java.util.stream.*;
import java.util.*;

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
