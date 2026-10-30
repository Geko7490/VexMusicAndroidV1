package com.vexmusic.player.lyrics

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="translations")
data class TranslationCache(@PrimaryKey val key: String, val targetLang: String, val translated: String, val updatedAt: Long=System.currentTimeMillis())

object TranslationManager {
    val languages = listOf("tr","en","es","de","fr","pt","it","ja","ko","ar","ru")
    suspend fun translate(original: String, target: String): String {
        // Call secure proxy - never expose keys in APK. Offline cache via Room.
        return original // placeholder for LibreTranslate / proxied provider
    }
    fun displayMode(mode: Int): String = when(mode){1->"Original" 2->"Translated" else->"Original + Translated"}
}
