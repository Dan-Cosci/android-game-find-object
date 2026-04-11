package com.example.mobilegame.Components;

import com.example.mobilegame.Utils.VectorF;

public class Transform extends BaseComponents{

    private VectorF position;

    public Transform(boolean state, VectorF position) {
        super(state);
        this.position = position;
    }

    public VectorF getPosition() {
        return position;
    }

    public void setPosition(VectorF position) {
        this.position = position;
    }
}
