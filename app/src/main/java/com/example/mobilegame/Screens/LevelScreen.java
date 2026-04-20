package com.example.mobilegame.Screens;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mobilegame.MainActivity;
import com.example.mobilegame.R;
import com.example.mobilegame.Util.Level;
import com.example.mobilegame.Util.States;

public class LevelScreen extends Fragment {
    public LevelScreen() {
        super(R.layout.fragment_level_screen);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            FrameLayout level1 = view.findViewById(R.id.level1);
            FrameLayout level2 = view.findViewById(R.id.level2);
            FrameLayout level3 = view.findViewById(R.id.level3);

            ImageView backBtn = view.findViewById(R.id.back_btn);

            backBtn.setOnClickListener(v -> {
                if (getActivity() instanceof MainActivity) {
                    ((MainActivity) getActivity()).getStateManager().switchState(States.TITLE);
                }
            });

            level1.setOnClickListener(v -> {
                if (getActivity() instanceof MainActivity) {
                    ((MainActivity) getActivity()).getStateManager().switchState(States.GAME, Level.LEVEL_1);
                }
            });

            level2.setOnClickListener(v -> {
                if (getActivity() instanceof MainActivity) {
                    ((MainActivity) getActivity()).getStateManager().switchState(States.GAME, Level.LEVEL_2);
                }
            });

            level3.setOnClickListener(v -> {
                if (getActivity() instanceof MainActivity) {
                    ((MainActivity) getActivity()).getStateManager().switchState(States.GAME, Level.LEVEL_3);
                }
            });
    }
}
