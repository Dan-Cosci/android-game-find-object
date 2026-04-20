package com.example.mobilegame.Screens;

import static android.view.View.VISIBLE;

import android.graphics.RectF;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mobilegame.MainActivity;
import com.example.mobilegame.R;
import com.example.mobilegame.Util.DebugOverlayView;
import com.example.mobilegame.Util.Level;
import com.example.mobilegame.Util.States;

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
        DebugOverlayView debugOverlay = view.findViewById(R.id.debug_overlay);
        View winLayout = view.findViewById(R.id.win_layout);

        FrameLayout nextBtn = view.findViewById(R.id.next_btn);
        FrameLayout titleBtn = view.findViewById(R.id.title_btn);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                winLayout.setVisibility(View.GONE);
                if (getActivity() instanceof MainActivity){
                    ((MainActivity) getActivity()).getStateManager().switchState(States.LEVEL);
                }
            }
        });

        titleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                winLayout.setVisibility(View.GONE);
                if (getActivity() instanceof MainActivity) {
                    ((MainActivity) getActivity()).getStateManager().switchState(States.TITLE);
                }
            }
        });

        // UI
        if (inst != null) {
            inst.setText(currentLevel.find);
        }

        if (img == null || debugOverlay == null) return;

        // Set image
        img.setImageResource(currentLevel.IMG_ID);

        // 👆 TOUCH (normalized coordinates)
        img.setOnTouchListener((v, event) -> {

            if (event.getAction() == MotionEvent.ACTION_DOWN) {

                float x = event.getX() / img.getWidth();
                float y = event.getY() / img.getHeight();

                if (x >= currentLevel.points.left && x <= currentLevel.points.right &&
                        y >= currentLevel.points.top && y <= currentLevel.points.bottom){
                    winLayout.setVisibility(VISIBLE);
                }

                return true;
            }

            return false;
        });

//        // DRAW HITBOX (wait until view is ready)
//        img.post(() -> {
//
//            RectF r = currentLevel.points; // normalized rect (0–1)
//
//            float w = img.getWidth();
//            float h = img.getHeight();
//
//            RectF scaled = new RectF(
//                    r.left * w,
//                    r.top * h,
//                    r.right * w,
//                    r.bottom * h
//            );
//
//            debugOverlay.setRect(scaled);
//        });
    }

    public void setLevel(Level level) {
        this.currentLevel = level;
    }
}