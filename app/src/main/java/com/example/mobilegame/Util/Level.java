package com.example.mobilegame.Util;

import com.example.mobilegame.R;

public enum Level {
    LEVEL_1(R.drawable.lvl_1, "Level 1", new LevelObject("fish", 100, 200)),
    LEVEL_2(R.drawable.lvl_2, "Level 2"),
    LEVEL_3(R.drawable.lvl_3, "Level 3");

    public static class LevelObject {
        public final String type;
        public final int x;
        public final int y;
        public final int width = 50;
        public final int height = 50;


        public LevelObject(String type, int x, int y) {
            this.type = type;
            this.x = x;
            this.y = y;
        }
    }
}
