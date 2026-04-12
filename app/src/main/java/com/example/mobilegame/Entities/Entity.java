package com.example.mobilegame.Entities;

public class Entity {

    private long id = 0;
    private String tag = "default";
    private boolean active = true;

    private Entity () {}
    public Entity (long  id, String tag){
        this.id = id;
        this.tag = tag;
    }

    public boolean isActive(){
        return active;
    }

    public void destroy (){
        this.active = false;
    }
    public String getTag (){
        return this.tag;
    }

    public long getId (){
        return this.id;
    }
}
