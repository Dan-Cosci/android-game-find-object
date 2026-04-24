package com.example.mobilegame.Util;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.media.SoundPool;

import com.example.mobilegame.R;

import java.util.HashMap;

public class SoundManager {

    private static SoundManager instance;
    private SoundPool soundPool;
    private HashMap<Integer, Integer> soundMap;
    private Context context;
    private MediaPlayer introThemePlayer;
    private MediaPlayer levelMusicPlayer;

    public static final int CLICK = R.raw.click_2;
    public static final int WIN = R.raw.win_1;
    public static final int ERROR = R.raw.error_2;
    public static final int INTRO = R.raw.intro_theme;

    private SoundManager(Context context) {
        this.context = context.getApplicationContext();
        
        AudioAttributes audioAttributes = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_GAME)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build();

        soundPool = new SoundPool.Builder()
                .setMaxStreams(5)
                .setAudioAttributes(audioAttributes)
                .build();

        soundMap = new HashMap<>();
        loadSound(CLICK);
        loadSound(WIN);
        loadSound(ERROR);
    }

    public static synchronized SoundManager getInstance(Context context) {
        if (instance == null) {
            instance = new SoundManager(context);
        }
        return instance;
    }

    private void loadSound(int resId) {
        int soundId = soundPool.load(context, resId, 1);
        soundMap.put(resId, soundId);
    }

    public void playSound(int resId) {
        if (soundMap.containsKey(resId)) {
            Integer soundId = soundMap.get(resId);
            if (soundId != null) {
                soundPool.play(soundId, 1.0f, 1.0f, 1, 0, 1.0f);
            }
        }
    }

    public void startIntroTheme() {
        if (introThemePlayer == null) {
            introThemePlayer = MediaPlayer.create(context, INTRO);
            introThemePlayer.setLooping(true);
            introThemePlayer.start();
        } else if (!introThemePlayer.isPlaying()) {
            introThemePlayer.start();
        }
    }

    public void stopIntroTheme() {
        if (introThemePlayer != null) {
            if (introThemePlayer.isPlaying()) {
                introThemePlayer.stop();
            }
            introThemePlayer.release();
            introThemePlayer = null;
        }
    }

    public void startLevelMusic(int musicId) {
        stopLevelMusic();
        levelMusicPlayer = MediaPlayer.create(context, musicId);
        levelMusicPlayer.setLooping(true);
        levelMusicPlayer.start();
    }

    public void stopLevelMusic() {
        if (levelMusicPlayer != null) {
            if (levelMusicPlayer.isPlaying()) {
                levelMusicPlayer.stop();
            }
            levelMusicPlayer.release();
            levelMusicPlayer = null;
        }
    }
}
