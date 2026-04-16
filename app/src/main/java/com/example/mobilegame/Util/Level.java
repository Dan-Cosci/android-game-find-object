package com.example.mobilegame.Util;

import com.example.mobilegame.R;

public enum Level {
    LEVEL_1(R.drawable.lvl_1, "Level 1", new LevelObject("person", 100, 200)),
    LEVEL_2(R.drawable.lvl_2, "Level 2"),
    LEVEL_3(R.drawable.lvl_3, "Level 3");

    private final int imageResId;
    private final String name;
    private final LevelObject[] objects;

    Level(int imageResId, String name, LevelObject... objects) {
        this.imageResId = imageResId;
        this.name = name;
        this.objects = objects;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getName() {
        return name;
    }

    public LevelObject[] getObjects() {
        return objects;
    }

    public static class LevelObject {
        public final String type;
        public final int x;
        public final int y;

        public LevelObject(String type, int x, int y) {
            this.type = type;
            this.x = x;
            this.y = y;
        }
    }
}
