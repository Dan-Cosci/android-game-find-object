# MobileGame - Find the Object

An Android game developed with Java where players find specific objects hidden in levels.

## Features

- **Level System**: Dynamic level loading using `Enum` to store level data (background images, target hitboxes, instructions, and music).
- **State Management**: Centralized `StateManager` to handle transitions between Title Screen, Level Selection, and Gameplay.
- **Audio Feedback**:
  - Looping intro theme on the Title Screen.
  - Level-specific background music.
  - Sound effects for button clicks, winning (finding the object), and errors (missing the object).
- **Haptic Feedback**: Immediate tactile response on both correct and incorrect taps.
- **Debug Layer**: A custom `DebugOverlayView` that highlights hitboxes (used during development).

## Architecture

- **MainActivity**: Entry point that delegates fragment management to the `StateManager`.
- **StateManager**: Handles fragment transactions and tracks the `States` enum.
- **Level Enum**: Contains all level-specific data, making it easy to add new content.
- **SoundManager**: A singleton handling `SoundPool` for effects and `MediaPlayer` for music.

## How to Play

1. Start at the **Title Screen** and press Play.
2. Select a level from the **Level Screen**.
3. In the **Game Screen**, follow the instruction (e.g., "Find Bao-Bao") and tap on the image.
4. Win to unlock the success overlay!
