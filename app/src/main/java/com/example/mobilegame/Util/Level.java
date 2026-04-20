package com.example.mobilegame.Util;

import android.graphics.PointF;
import android.graphics.RectF;

import com.example.mobilegame.R;

public enum Level {

    LEVEL_1(R.drawable.final_lvl_1, "Find Bao-Bao", new RectF(0.77f,0.58f,0.92f,0.76f)),
    LEVEL_2(R.drawable.final_lvl_2, "Find The woman with the yellow scraf", new RectF(0.42f,0.34f,0.47f,0.40f)),
    LEVEL_3(R.drawable.final_lvl_3, "Find the yellow book", new RectF(0.12f,0.43f,0.14f,0.50f));


    public final int IMG_ID;
    public final String find;
    public final RectF points;

    Level(int img_id, String s, RectF points) {
        this.IMG_ID = img_id;
        this.find = s;
        this.points = points;
    }
}
