package com.vexmusic.player.data.local.db
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
val MIGRATION_3_4 = object: Migration(3,4){
    override fun migrate(db: SupportSQLiteDatabase){ db.execSQL("CREATE TABLE IF NOT EXISTS history (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, songId TEXT NOT NULL, playedAt INTEGER NOT NULL, progressMs INTEGER NOT NULL)") }
}
