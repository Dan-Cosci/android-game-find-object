 package com.example.mobilegame;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

 public class MainActivity extends AppCompatActivity {

     private States currentState = States.TITLE ;

     private TitleScreen titleScreen = new TitleScreen();

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

        switch (state){
            case TITLE:
                f = titleScreen;
                break;

            default:
                f = titleScreen;
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