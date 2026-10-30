package com.vexmusic.player.ui.navigation

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.compose.*
import com.vexmusic.player.ui.screens.*
import com.vexmusic.player.ui.theme.VexColors

sealed class VexRoute(val route: String, val label: String, val icon: ImageVector) {
    data object Home : VexRoute("home", "Home", Icons.Filled.Home)
    data object Library : VexRoute("library", "Library", Icons.Filled.LibraryMusic)
    data object Search : VexRoute("search", "Search", Icons.Filled.Search)
    data object Playlists : VexRoute("playlists", "Playlists", Icons.Filled.QueueMusic)
    data object Settings : VexRoute("settings", "Settings", Icons.Filled.Settings)
}

@Composable
fun VexNavHost() {
    val navController = rememberNavController()
    val items = listOf(VexRoute.Home, VexRoute.Library, VexRoute.Search, VexRoute.Playlists, VexRoute.Settings)
    var selected by remember { mutableStateOf("home") }
    Scaffold(
        containerColor = VexColors.Background,
        bottomBar = {
            NavigationBar(containerColor = VexColors.Surface) {
                items.forEach { item ->
                    NavigationBarItem(
                        selected = selected == item.route,
                        onClick = { selected = item.route; navController.navigate(item.route) { launchSingleTop = true } },
                        icon = { Icon(item.icon, contentDescription = item.label) },
                        label = { Text(item.label) },
                        colors = NavigationBarItemDefaults.colors(selectedIconColor = VexColors.Primary, indicatorColor = VexColors.Primary.copy(alpha=0.18f))
                    )
                }
            }
        }
    ) { padding ->
        NavHost(navController, startDestination = "home", modifier = Modifier.padding(padding)) {
            composable("home") { HomeScreen() }
            composable("library") { LibraryScreen() }
            composable("search") { SearchScreen() }
            composable("playlists") { PlaylistsScreen() }
            composable("settings") { SettingsScreen() }
            composable("nowplaying") { NowPlayingScreen() }
            composable("lyrics") { LyricsSelectionScreen() }
        }
    }
}
