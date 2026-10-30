# VEX MUSIC — Native Android Player

Package: `com.vexmusic.player` • Min SDK 24 • Target 34 • Kotlin + Compose + Media3

## Build locally
```bash
./gradlew assembleDebug
# APK: app/build/outputs/apk/debug/app-debug.apk
adb install -r app/build/outputs/apk/debug/app-debug.apk
```

## GitHub Actions
Workflow `.github/workflows/android-build.yml` builds debug APK on every push.

## Features
- Local import via SAF/MediaStore, Room metadata, ExoPlayer + MediaSessionService background playback, notification/lock-screen controls
- Multi-provider lyrics: LRCLIB (primary), KuGou, BetterLyrics, Paxsenix, ArchiveTune - common interface, manual selection, LRC parser & sync
- Translation overlay (10 languages), offline cache, equalizer (AudioEffect), visualizer (Visualizer API), playlists/favorites/history, storage manager, backup/restore
- VEX Purple design: #A855F7 on #0F0F13, Material 3

## Architecture
MVVM + Repository, Room + DataStore, Retrofit/Ktor, Coroutines, Hilt.

