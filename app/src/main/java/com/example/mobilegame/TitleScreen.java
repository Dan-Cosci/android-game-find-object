package com.example.mobilegame;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class TitleScreen extends Fragment {

    public TitleScreen() {
        super(R.layout.fragment_title_screen);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Setup UI here (buttons, etc.)
    }
}