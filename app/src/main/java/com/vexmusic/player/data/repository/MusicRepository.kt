package com.vexmusic.player.data.repository

import com.vexmusic.player.data.local.db.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MusicRepository @Inject constructor(private val db: VexDatabase) {
    suspend fun getSongs() = withContext(Dispatchers.IO){ db.songDao().getAll() }
    suspend fun search(q: String) = withContext(Dispatchers.IO){ db.songDao().search(q) }
    suspend fun deleteSong(id: String) = withContext(Dispatchers.IO){ db.songDao().delete(id) }
    suspend fun getLyrics(songId: String) = db.lyricsDao().getForSong(songId)
    suspend fun saveLyrics(e: LyricsEntity) = db.lyricsDao().save(e)
}
