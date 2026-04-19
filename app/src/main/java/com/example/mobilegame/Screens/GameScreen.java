package com.example.mobilegame.Screens;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mobilegame.R;
import com.example.mobilegame.Util.DebugOverlayView;
import com.example.mobilegame.Util.Level;

public class GameScreen extends Fragment {

    private Level currentLevel;


    public GameScreen() {
        super(R.layout.fragment_game_screen);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (currentLevel == null) return;

        ImageView img = view.findViewById(R.id.game_img);
        TextView inst = view.findViewById(R.id.game_inst);

        if (inst != null) inst.setText(currentLevel.find);
        if (img != null) {
            img.setImageResource(currentLevel.IMG_ID
            );

            img.setOnTouchListener((v, event) -> {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    float raw_x = event.getX();
                    float raw_y = event.getY();

                    float x = raw_x / img.getWidth();
                    float y = raw_y / img.getHeight();

                    System.out.println("x: " + x + " y: " + y);
                    return true;
                }
                return false;
            });
        }

        DebugOverlayView debug_overlay = view.findViewById(R.id.debug_overlay);
        if (debug_overlay != null) {
            debug_overlay.setRect(currentLevel.points);
        }
    }

    public void setLevel(Level level){
        currentLevel = level;
    }
}