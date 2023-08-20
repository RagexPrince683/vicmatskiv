package com.vicmatskiv.weaponlib.config;

import javax.xml.bind.annotation.*;
import java.util.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Projectiles", propOrder = { "gun" })
public class Projectiles
{
    protected List<Gun> gun;
    @XmlAttribute(name = "bleedingOnHit")
    protected Float bleedingOnHit;
    @XmlAttribute(name = "destroyGlassBlocks")
    protected Boolean destroyGlassBlocks;
    @XmlAttribute(name = "knockbackOnHit")
    protected Boolean knockbackOnHit;
    @XmlAttribute(name = "muzzleEffects")
    protected Boolean muzzleEffects;
    
    public Projectiles() {
        super();
    }
    
    public List<Gun> getGun() {
        if (this.gun == null) {
            this.gun = new ArrayList<Gun>();
        }
        return this.gun;
    }
    
    public Float getBleedingOnHit() {
        return this.bleedingOnHit;
    }
    
    public void setBleedingOnHit(final Float value) {
        this.bleedingOnHit = value;
    }
    
    public Boolean isDestroyGlassBlocks() {
        return this.destroyGlassBlocks;
    }
    
    public void setDestroyGlassBlocks(final Boolean value) {
        this.destroyGlassBlocks = value;
    }
    
    public Boolean isKnockbackOnHit() {
        return this.knockbackOnHit;
    }
    
    public void setKnockbackOnHit(final Boolean value) {
        this.knockbackOnHit = value;
    }
    
    public Boolean isMuzzleEffects() {
        return this.muzzleEffects;
    }
    
    public void setMuzzleEffects(final Boolean value) {
        this.muzzleEffects = value;
    }
}
