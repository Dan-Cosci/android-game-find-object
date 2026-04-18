package com.example.mobilegame.Util;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.mobilegame.R;
import com.example.mobilegame.Screens.GameOverScreen;
import com.example.mobilegame.Screens.GameScreen;
import com.example.mobilegame.Screens.LevelScreen;
import com.example.mobilegame.Screens.PauseScreen;
import com.example.mobilegame.Screens.TitleScreen;

import com.example.mobilegame.Util.Level;
import com.example.mobilegame.Util.States;

public class StateManager {
    private final FragmentManager fragmentManager;
    private final int containerId;
    private States currentState;
    private Level currentLevel;

    private final TitleScreen titleScreen = new TitleScreen();
    private final LevelScreen levelScreen = new LevelScreen();
    private final GameScreen gameScreen = new GameScreen();
    private final PauseScreen pauseScreen = new PauseScreen();
    private final GameOverScreen gameOverScreen = new GameOverScreen();

    public StateManager(FragmentManager fragmentManager, int containerId) {
        this.fragmentManager = fragmentManager;
        this.containerId = containerId;
    }

    public void switchState(States state) {
        switchState(state, null);
    }

    public void switchState(States state, Level level) {
        if (this.currentState == state && this.currentLevel == level) return;
        this.currentState = state;
        this.currentLevel = level;
        loadState(state);
    }

    public void loadState(States state) {
        this.currentState = state;
        Fragment f = null;

        switch (state) {
            case TITLE:
                f = titleScreen;
                break;
            case LEVEL:
                f = levelScreen;
                break;
            case GAME:
                gameScreen.setLevel(currentLevel);
                f = gameScreen;
                break;
            case PAUSE:
                f = pauseScreen;
                break;
            case GAME_OVER:
                f = gameOverScreen;
                break;
        }

        if (f != null) {
            fragmentManager.beginTransaction()
                    .replace(containerId, f)
                    .commit();
        }
    }

    public States getCurrentState() {
        return currentState;
    }

    public Level getCurrentLevel() {
        return currentLevel;
    }
}
