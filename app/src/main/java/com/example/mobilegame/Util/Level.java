package com.example.mobilegame.Util;

import android.graphics.PointF;
import android.graphics.RectF;

import com.example.mobilegame.R;

public enum Level {

    LEVEL_1(R.drawable.final_lvl_1, "Find Bao-Bao", new RectF(100,100,300,300)),
    LEVEL_2(R.drawable.final_lvl_2, "Find The woman with the yellow scraf", new RectF(100,100,300,300)),
    LEVEL_3(R.drawable.final_lvl_3, "Find the yellow book", new RectF(100,100,300,300));


    public final int IMG_ID;
    public final String find;
    public final RectF points;

    Level(int img_id, String s, RectF points) {
        this.IMG_ID = img_id;
        this.find = s;
        this.points = points;
    }
}
