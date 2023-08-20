package com.vicmatskiv.weaponlib.grenade;

import net.minecraft.client.model.*;
import net.minecraft.item.*;
import com.vicmatskiv.weaponlib.animation.*;
import java.util.function.*;
import com.vicmatskiv.weaponlib.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import org.lwjgl.opengl.*;
import java.util.stream.*;
import java.util.*;

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
