package com.example.mobilegame.Screens;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.mobilegame.MainActivity;
import com.example.mobilegame.R;
import com.example.mobilegame.Util.SoundManager;
import com.example.mobilegame.Util.States;

public class TitleScreen extends Fragment {
    public TitleScreen() {
        super(R.layout.fragment_title_screen);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SoundManager.getInstance(getContext()).startIntroTheme();

        FrameLayout play_btn = view.findViewById(R.id.play_btn);

        play_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SoundManager.getInstance(getContext()).playSound(SoundManager.CLICK);
                if (getActivity() instanceof MainActivity){
                    ((MainActivity) getActivity()).getStateManager().switchState(States.LEVEL);
                }
            }
        });
    }
}