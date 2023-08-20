package com.vicmatskiv.weaponlib.config;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Gun")
public class Gun
{
    @XmlAttribute(name = "id")
    protected String id;
    @XmlAttribute(name = "enabled")
    protected Boolean enabled;
    
    public Gun() {
        super();
    }
    
    public String getId() {
        return this.id;
    }
    
    public void setId(final String value) {
        this.id = value;
    }
    
    public boolean isEnabled() {
        return this.enabled == null || this.enabled;
    }
    
    public void setEnabled(final Boolean value) {
        this.enabled = value;
    }
}
