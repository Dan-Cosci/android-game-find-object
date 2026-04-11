package com.example.mobilegame.Components;

public class BaseComponents {

    private boolean component;

    public BaseComponents(boolean state){
        this.component = state;
    }

    public boolean isComponent() {
        return component;
    }

    public void setComponent(boolean component) {
        this.component = component;
    }
}
