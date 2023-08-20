package com.vicmatskiv.weaponlib.melee;

import net.minecraft.client.model.*;
import java.util.function.*;
import net.minecraft.item.*;
import com.vicmatskiv.weaponlib.animation.*;
import com.vicmatskiv.weaponlib.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import org.lwjgl.opengl.*;
import java.util.stream.*;
import java.util.*;

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
