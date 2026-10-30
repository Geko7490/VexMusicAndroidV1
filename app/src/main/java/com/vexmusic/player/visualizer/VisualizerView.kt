package com.vexmusic.player.visualizer

import android.media.audiofx.Visualizer
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import com.vexmusic.player.ui.theme.VexColors

enum class VisualizerMode { BARS, WAVEFORM, CIRCULAR, MINIMAL, SPECTRUM }

@Composable
fun AudioVisualizer(modifier: Modifier = Modifier, mode: VisualizerMode = VisualizerMode.BARS, audioSessionId: Int = 0) {
    var waveform by remember { mutableStateOf(ByteArray(128)) }
    // Real Visualizer: Visualizer(audioSessionId).setCaptureSize(...).setDataCaptureListener(...)
    Canvas(modifier = modifier) {
        val barWidth = size.width / 32
        repeat(32) { i ->
            val h = (waveform.getOrNull(i)?.toInt()?.let { kotlin.math.abs(it.toDouble()) } ?: 20.0) * 2
            drawRect(color = VexColors.Primary, topLeft = Offset(i*barWidth, size.height/2 - h.toFloat()/2), size = androidx.compose.ui.geometry.Size(barWidth*0.7f, h.toFloat()))
        }
    }
}
