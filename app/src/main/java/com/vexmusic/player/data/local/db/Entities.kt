package com.vexmusic.player.data.local.db

import androidx.room.*
import kotlinx.serialization.Serializable

@Entity(tableName = "songs")
data class SongEntity(
    @PrimaryKey val id: String,
    val title: String,
    val artist: String,
    val album: String?,
    val durationMs: Long,
    val path: String,
    val artworkUri: String?,
    val dateAdded: Long = System.currentTimeMillis(),
    val playCount: Int = 0
)

@Entity(tableName = "lyrics")
data class LyricsEntity(
    @PrimaryKey val songId: String,
    val provider: String,
    val providerId: String?,
    val language: String?,
    val isSynced: Boolean,
    val originalText: String,
    val lrcText: String?,
    val selectedAt: Long = System.currentTimeMillis()
)

@Entity(tableName = "playlists")
data class PlaylistEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val createdAt: Long = System.currentTimeMillis(),
    val artwork: String? = null
)

@Entity(primaryKeys = ["playlistId","songId"], tableName = "playlist_songs")
data class PlaylistSongCrossRef(
    val playlistId: Long,
    val songId: String,
    val position: Int
)

@Entity(tableName = "history")
data class HistoryEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val songId: String,
    val playedAt: Long = System.currentTimeMillis(),
    val progressMs: Long = 0
)

@Dao
interface SongDao {
    @Query("SELECT * FROM songs ORDER BY dateAdded DESC") suspend fun getAll(): List<SongEntity>
    @Query("SELECT * FROM songs WHERE title LIKE '%' || :q || '%' OR artist LIKE '%' || :q || '%'") suspend fun search(q: String): List<SongEntity>
    @Insert(onConflict = OnConflictStrategy.REPLACE) suspend fun insertAll(vararg songs: SongEntity)
    @Query("DELETE FROM songs WHERE id = :id") suspend fun delete(id: String)
}

@Dao
interface LyricsDao {
    @Query("SELECT * FROM lyrics WHERE songId = :songId LIMIT 1") suspend fun getForSong(songId: String): LyricsEntity?
    @Insert(onConflict = OnConflictStrategy.REPLACE) suspend fun save(entity: LyricsEntity)
    @Query("DELETE FROM lyrics") suspend fun clearAll()
}

@Dao
interface PlaylistDao {
    @Query("SELECT * FROM playlists ORDER BY createdAt DESC") suspend fun getAll(): List<PlaylistEntity>
    @Insert suspend fun insert(playlist: PlaylistEntity): Long
    @Query("DELETE FROM playlists WHERE id = :id") suspend fun delete(id: Long)
}

@Database(entities = [SongEntity::class, LyricsEntity::class, PlaylistEntity::class, PlaylistSongCrossRef::class, HistoryEntity::class], version = 4)
abstract class VexDatabase : RoomDatabase() {
    abstract fun songDao(): SongDao
    abstract fun lyricsDao(): LyricsDao
    abstract fun playlistDao(): PlaylistDao
}
