package com.vexmusic.player.lyrics.providers

import retrofit2.http.GET
import retrofit2.http.Query

data class LrcLibResponse(
    val id: Long,
    val name: String,
    val trackName: String,
    val artistName: String,
    val albumName: String?,
    val duration: Double?,
    val instrumental: Boolean,
    val plainLyrics: String?,
    val syncedLyrics: String?
)

interface LrcLibService {
    @GET("api/get")
    suspend fun getByTrack(@Query("track_name") track: String, @Query("artist_name") artist: String, @Query("album_name") album: String?, @Query("duration") duration: Double?): LrcLibResponse
    @GET("api/search")
    suspend fun search(@Query("q") q: String): List<LrcLibResponse>
}

class LrcLibLyricsProvider(private val service: LrcLibService) : LyricsProvider {
    override val name = "LRCLIB"
    override val isEnabled = true
    override suspend fun search(title: String, artist: String, durationMs: Long?): List<LyricsCandidate> {
        return try {
            val res = service.search("$title $artist")
            res.map { r -> LyricsCandidate(provider=name, title=r.trackName, artist=r.artistName, durationMs = r.duration?.times(1000)?.toLong(), isSynced = !r.syncedLyrics.isNullOrBlank(), preview = r.plainLyrics?.take(140) ?: r.syncedLyrics?.take(140) ?: "", fullText = r.plainLyrics ?: "", lrc = r.syncedLyrics) }
        } catch(e: Exception) { emptyList() }
    }
}
