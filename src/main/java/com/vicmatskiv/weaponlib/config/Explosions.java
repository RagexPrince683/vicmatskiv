package com.vicmatskiv.weaponlib.config;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Explosions")
public class Explosions
{
    @XmlAttribute(name = "damage")
    protected Float damage;
    @XmlAttribute(name = "dropBlockChance")
    protected Float dropBlockChance;
    
    public Explosions() {
        super();
    }
    
    public Float getDamage() {
        return this.damage;
    }
    
    public void setDamage(final Float value) {
        this.damage = value;
    }
    
    public Float getDropBlockChance() {
        return this.dropBlockChance;
    }
    
    public void setDropBlockChance(final Float value) {
        this.dropBlockChance = value;
    }
}
