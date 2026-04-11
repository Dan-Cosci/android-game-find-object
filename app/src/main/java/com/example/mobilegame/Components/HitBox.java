package com.example.mobilegame.Components;

public class HitBox extends  BaseComponents{
    private int height, width;
    public HitBox(boolean state, int height, int width) {
        super(state);
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
