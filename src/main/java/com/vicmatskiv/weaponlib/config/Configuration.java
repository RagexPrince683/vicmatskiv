package com.vicmatskiv.weaponlib.config;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Configuration", propOrder = { "ores", "explosions", "projectiles", "gui" })
public class Configuration
{
    protected Ores ores;
    protected Explosions explosions;
    protected Projectiles projectiles;
    protected Gui gui;
    
    public Configuration() {
        super();
    }
    
    public Ores getOres() {
        return this.ores;
    }
    
    public void setOres(final Ores value) {
        this.ores = value;
    }
    
    public Explosions getExplosions() {
        return this.explosions;
    }
    
    public void setExplosions(final Explosions value) {
        this.explosions = value;
    }
    
    public Projectiles getProjectiles() {
        return this.projectiles;
    }
    
    public void setProjectiles(final Projectiles value) {
        this.projectiles = value;
    }
    
    public Gui getGui() {
        return this.gui;
    }
    
    public void setGui(final Gui value) {
        this.gui = value;
    }
}
