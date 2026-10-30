package com.vexmusic.player.data.local.datastore

import android.content.Context
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.map

val Context.dataStore by preferencesDataStore("vex_prefs")

object PrefKeys {
    val THEME = stringPreferencesKey("theme")
    val LANGUAGE = stringPreferencesKey("language")
    val AUTO_LYRICS = booleanPreferencesKey("auto_lyrics")
    val TRANSLATE_TARGET = stringPreferencesKey("translate_target")
    val EQUALIZER_ENABLED = booleanPreferencesKey("eq_enabled")
    val PROVIDER_LRCLIB = booleanPreferencesKey("provider_lrclib")
    val PROVIDER_KUGOU = booleanPreferencesKey("provider_kugou")
    val PROVIDER_BETTER = booleanPreferencesKey("provider_better")
    val PROVIDER_PAXSENIX = booleanPreferencesKey("provider_paxsenix")
}
