package com.example.mobilegame.Screens;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mobilegame.R;

public class GameScreen extends Fragment {



    public GameScreen() {
        super(R.layout.fragment_game_screen);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView to_find = view.findViewById(R.id.to_find);
        ImageView img = view.findViewById(R.id.img);

        img.setImageResource(R.drawable.lvl_1);
        to_find.setImageResource(R.drawable.logo);

        img.setOnTouchListener((v,event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                float x = event.getX();
                float y = event.getY();
                System.out.println("x: " + x + " y: " + y);
                return true;
            }
            return false;
        });


    }
}