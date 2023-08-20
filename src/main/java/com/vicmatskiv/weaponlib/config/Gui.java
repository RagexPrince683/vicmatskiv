package com.vicmatskiv.weaponlib.config;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Gui")
public class Gui
{
    @XmlAttribute(name = "statusBarPosition", required = true)
    protected String statusBarPosition;
    
    public Gui() {
        super();
    }
    
    public String getStatusBarPosition() {
        return this.statusBarPosition;
    }
    
    public void setStatusBarPosition(final String value) {
        this.statusBarPosition = value;
    }
}
