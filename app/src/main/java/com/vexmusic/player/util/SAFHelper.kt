package com.vexmusic.player.util
import android.content.Context
import android.net.Uri
import android.provider.MediaStore
object SAFHelper {
    fun importFromPicker(context: Context, uris: List<Uri>) { /* read metadata via MediaMetadataRetriever, copy to app cache, insert Room */ }
    fun scanMediaStore(context: Context) { /* query MediaStore.Audio.Media with permission READ_MEDIA_AUDIO */ }
}
