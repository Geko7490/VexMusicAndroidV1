package com.vexmusic.player.playback

import androidx.media3.common.AudioAttributes
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.session.MediaSession
import androidx.media3.session.MediaSessionService

class VexPlaybackService : MediaSessionService() {
    private var mediaSession: MediaSession? = null
    private var player: Player? = null

    override fun onCreate() {
        super.onCreate()
        player = ExoPlayer.Builder(this)
            .setAudioAttributes(AudioAttributes.DEFAULT, true)
            .setHandleAudioBecomingNoisy(true)
            .build()
        mediaSession = MediaSession.Builder(this, player!!).build()
    }

    override fun onGetSession(controllerInfo: MediaSession.ControllerInfo) = mediaSession

    override fun onDestroy() {
        mediaSession?.release(); player?.release(); super.onDestroy()
    }
}

// ViewModel wrapper for UI
class PlaybackViewModel : androidx.lifecycle.ViewModel() {
    var isPlaying = androidx.compose.runtime.mutableStateOf(false)
    var currentPosition = androidx.compose.runtime.mutableStateOf(0L)
    var queue = androidx.compose.runtime.mutableStateListOf<com.vexmusic.player.data.local.db.SongEntity>()
    fun play() { isPlaying.value = true }
    fun pause() { isPlaying.value = false }
    fun next() {}
    fun prev() {}
    fun seekTo(ms: Long) { currentPosition.value = ms }
    fun setShuffle(enabled: Boolean) {}
    fun setRepeat(mode: Int) {}
}
