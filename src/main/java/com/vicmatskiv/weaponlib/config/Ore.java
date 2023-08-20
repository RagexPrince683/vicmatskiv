package com.vicmatskiv.weaponlib.config;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Ore")
public class Ore
{
    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "spawnsPerChunk")
    protected Integer spawnsPerChunk;
    
    public Ore() {
        super();
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(final String value) {
        this.name = value;
    }
    
    public Integer getSpawnsPerChunk() {
        return this.spawnsPerChunk;
    }
    
    public void setSpawnsPerChunk(final Integer value) {
        this.spawnsPerChunk = value;
    }
}
