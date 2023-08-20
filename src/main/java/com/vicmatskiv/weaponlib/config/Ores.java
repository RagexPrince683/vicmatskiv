package com.vicmatskiv.weaponlib.config;

import javax.xml.bind.annotation.*;
import java.util.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Ores", propOrder = { "ore" })
public class Ores
{
    protected List<Ore> ore;
    
    public Ores() {
        super();
    }
    
    public List<Ore> getOre() {
        if (this.ore == null) {
            this.ore = new ArrayList<Ore>();
        }
        return this.ore;
    }
}
