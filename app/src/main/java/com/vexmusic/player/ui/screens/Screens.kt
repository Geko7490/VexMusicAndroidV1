package com.vexmusic.player.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.vexmusic.player.ui.theme.VexColors
import com.vexmusic.player.lyrics.providers.LyricsCandidate

@Composable fun HomeScreen() { Placeholder("Home","Recently played, mixes, most played") }
@Composable fun LibraryScreen() { Placeholder("Library","Artists • Albums • Songs • Sort & filter") }
@Composable fun SearchScreen() { Placeholder("Search","Search title / artist / album / playlist") }
@Composable fun PlaylistsScreen() { Placeholder("Playlists","Create • Rename • Reorder • Favorites") }
@Composable fun SettingsScreen() { Placeholder("Settings","Language • Providers • Equalizer • Storage • Backup") }
@Composable fun NowPlayingScreen() {
    Column(Modifier.fillMaxSize().background(VexColors.Background).padding(16.dp)) {
        Text("Now Playing", color = Color.White, style = MaterialTheme.typography.titleLarge)
        Spacer(Modifier.height(20.dp))
        Card(colors = CardDefaults.cardColors(containerColor = VexColors.Card)) {
            Column(Modifier.fillMaxWidth().padding(16.dp)) {
                Text("Playback • Queue • Seek • Shuffle • Repeat • Speed", color = VexColors.TextSecondary)
                LinearProgressIndicator(progress = {0.42f}, color = VexColors.Primary, modifier = Modifier.fillMaxWidth().padding(top=12.dp))
            }
        }
    }
}
@Composable fun LyricsSelectionScreen() {
    Column(Modifier.fillMaxSize().background(VexColors.Background).padding(16.dp)) {
        Text("Manual Lyrics Selection", color = Color.White, style = MaterialTheme.typography.titleLarge)
        Text("VEX searches all enabled providers. You choose the correct one.", color = VexColors.TextSecondary)
        Spacer(Modifier.height(16.dp))
        val mock = listOf("LRCLIB — Synchronized LRC","KuGou — Synchronized","BetterLyrics — Synced","Paxsenix — Plain","ArchiveTune — Synced")
        mock.forEach { p ->
            Card(Modifier.fillMaxWidth().padding(vertical=6.dp), colors = CardDefaults.cardColors(containerColor = VexColors.Card)) {
                Row(Modifier.fillMaxWidth().padding(12.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                    Column { Text(p, color = Color.White); Text("Preview: first lines of lyrics...", color = VexColors.TextSecondary, style = MaterialTheme.typography.bodySmall) }
                    Button(onClick={}, colors = ButtonDefaults.buttonColors(containerColor = VexColors.Primary)) { Text("Select") }
                }
            }
        }
        OutlinedButton(onClick={}, modifier = Modifier.fillMaxWidth().padding(top=12.dp)) { Text("Search Again") }
    }
}
@Composable private fun Placeholder(title: String, desc: String) {
    Column(Modifier.fillMaxSize().background(VexColors.Background).padding(24.dp)) {
        Text(title, color = Color.White, style = MaterialTheme.typography.titleLarge)
        Text(desc, color = VexColors.TextSecondary)
        Spacer(Modifier.height(16.dp))
        Card(colors = CardDefaults.cardColors(containerColor = VexColors.Card)) { Box(Modifier.fillMaxWidth().height(120.dp).padding(16.dp)) { Text("VEX Purple • Material 3 • Offline-first", color = VexColors.TextSecondary)} }
    }
}
