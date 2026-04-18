package com.example.mobilegame.Util;

import android.graphics.PointF;

import com.example.mobilegame.R;

public enum Level {

    LEVEL_1(R.drawable.final_lvl_1, "find the woman with the yellow scarf", new PointF[]{ new PointF(100, 100), new PointF(300, 300)}),
    LEVEL_2(R.drawable.final_lvl_2, "Find The woman with the yellow scraf", new PointF[]{ new PointF(100, 100), new PointF(300, 300)}),
    LEVEL_3(R.drawable.final_lvl_3, "Find the yellow book", new PointF[]{ new PointF(100, 100), new PointF(300, 300)});


    public final int IMG_ID;
    public final String find;
    public final PointF[] points;

    Level(int img_id, String s, PointF[] points) {
        this.IMG_ID = img_id;
        this.find = s;
        this.points = points;
    }
}
