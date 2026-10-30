package com.vexmusic.player.equalizer

import android.media.audiofx.Equalizer

class EqualizerManager(private val audioSessionId: Int) {
    private var eq: Equalizer? = null
    val presets = listOf("Flat","Bass Boost","Treble Boost","Rock","Pop","Hip-Hop","Classical","Electronic","Vocal")
    fun init(): Boolean = try {
        eq = Equalizer(0, audioSessionId).apply { enabled = true }
        true
    } catch (e: Exception) { false }

    fun setBandLevel(band: Short, level: Short) { eq?.setBandLevel(band, level) }
    fun getBands(): Short = eq?.numberOfBands ?: 0
    fun release() { eq?.release() }
    fun applyPreset(name: String) {
        // 10-band mapping per preset
    }
}
