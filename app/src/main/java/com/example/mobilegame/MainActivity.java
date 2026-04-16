 package com.example.mobilegame;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.mobilegame.Screens.GameOverScreen;
import com.example.mobilegame.Screens.GameScreen;
import com.example.mobilegame.Screens.LevelScreen;
import com.example.mobilegame.Screens.PauseScreen;
import com.example.mobilegame.Screens.TitleScreen;

 public class MainActivity extends AppCompatActivity {

     private States currentState = States.TITLE ;

     private final TitleScreen titleScreen = new TitleScreen();
     private final LevelScreen levelScreen = new LevelScreen();
     private final GameScreen gameScreen = new GameScreen();
     private final PauseScreen pauseScreen = new PauseScreen();
     private final GameOverScreen gameOverScreen = new GameOverScreen();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            // 🔁 Restore state
            String saved = savedInstanceState.getString("current_screen");

            if (saved != null) {
                currentState = States.valueOf(saved);
                loadState(currentState);
            }
        } else {
            // 🚀 First launch
            switchState(States.TITLE);
        }

        loadState(currentState);

    }

    public void switchState(States state){
        if (currentState == state) return;

        currentState = state;
        loadState(state);
    }

    private void loadState(States state){
        Fragment f = null;

        switch (state) {
            case TITLE:
                f = titleScreen;
                break;
            case LEVEL:
                f = levelScreen;
                break;
            case GAME:
                f = gameScreen;
                break;
            case PAUSE:
                f = pauseScreen;
                break;
            case GAME_OVER:
                f = gameOverScreen;
                break;
        }

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainerView, f)
                .commit();
    }

     @Override
     public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
         super.onSaveInstanceState(outState, outPersistentState);
         outState.putString("currentState", String.valueOf(currentState));
     }
 }