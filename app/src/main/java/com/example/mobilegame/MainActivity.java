package com.example.mobilegame;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mobilegame.Util.StateManager;
import com.example.mobilegame.Util.States;

public class MainActivity extends AppCompatActivity {

    private StateManager stateManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        stateManager = new StateManager(getSupportFragmentManager(), R.id.fragmentContainerView);

        if (savedInstanceState != null) {
            // 🔁 Restore state
            String saved = savedInstanceState.getString("currentState");

            if (saved != null) {
                stateManager.loadState(States.valueOf(saved));
            }
        } else {
            // 🚀 First launch
            stateManager.switchState(States.TITLE);
        }
    }

    public StateManager getStateManager() {
        return stateManager;
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (stateManager != null && stateManager.getCurrentState() != null) {
            outState.putString("currentState", stateManager.getCurrentState().name());
        }
    }
}
