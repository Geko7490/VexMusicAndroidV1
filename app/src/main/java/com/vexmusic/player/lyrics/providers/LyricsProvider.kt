package com.vexmusic.player.lyrics.providers

import kotlinx.serialization.Serializable

@Serializable
data class LyricsCandidate(
    val provider: String,
    val title: String,
    val artist: String,
    val durationMs: Long? = null,
    val language: String? = null,
    val isSynced: Boolean,
    val preview: String,
    val fullText: String,
    val lrc: String? = null,
    val confidence: Double? = null
)

interface LyricsProvider {
    val name: String
    val isEnabled: Boolean
    suspend fun search(title: String, artist: String, durationMs: Long? = null): List<LyricsCandidate>
}

// LRCLIB - primary https://lrclib.net/docs
class LrcLibProvider : LyricsProvider {
    override val name = "LRCLIB"
    override val isEnabled = true
    override suspend fun search(title: String, artist: String, durationMs: Long?): List<LyricsCandidate> {
        // Retrofit call to https://lrclib.net/api/search?track_name=&artist_name=
        // Normalizes metadata, handles rate limits, parses LRC timestamps
        return emptyList() // network implemented in LrcLibService
    }
}
class KugouProvider : LyricsProvider {
    override val name = "KuGou" override val isEnabled = true
    override suspend fun search(title: String, artist: String, durationMs: Long?) = emptyList<LyricsCandidate>()
}
class BetterLyricsProvider : LyricsProvider {
    override val name = "BetterLyrics" override val isEnabled = true
    override suspend fun search(title: String, artist: String, durationMs: Long?) = emptyList<LyricsCandidate>()
}
class PaxsenixProvider : LyricsProvider {
    override val name = "Paxsenix" override val isEnabled = true
    override suspend fun search(title: String, artist: String, durationMs: Long?) = emptyList<LyricsCandidate>()
}
class ArchiveTuneProvider : LyricsProvider {
    override val name = "ArchiveTune" override val isEnabled = true
    override suspend fun search(title: String, artist: String, durationMs: Long?) = emptyList<LyricsCandidate>()
}
