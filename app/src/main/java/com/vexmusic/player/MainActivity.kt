package com.vexmusic.player

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.core.view.WindowCompat
import com.vexmusic.player.ui.navigation.VexNavHost
import com.vexmusic.player.ui.theme.VexMusicTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            VexMusicTheme {
                Surface(modifier = androidx.compose.ui.Modifier.fillMaxSize(), color = VexMusicTheme.colors.background) {
                    VexNavHost()
                }
            }
        }
    }
}
