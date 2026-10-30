package com.vexmusic.player.lyrics.parser

data class LrcLine(val timestampMs: Long, val text: String, val words: List<LrcWord> = emptyList())
data class LrcWord(val offsetMs: Long, val text: String)

object LrcParser {
    private val timeRegex = Regex("""\[(\d{1,2}):(\d{2})(?:\.(\d{1,3}))?]""")
    fun parse(lrc: String): List<LrcLine> {
        val lines = mutableListOf<LrcLine>()
        lrc.lines().forEach { raw ->
            val matches = timeRegex.findAll(raw).toList()
            if (matches.isEmpty()) return@forEach
            val text = timeRegex.replace(raw, "").trim()
            matches.forEach { m ->
                val min = m.groupValues[1].toLong()
                val sec = m.groupValues[2].toLong()
                val msPart = m.groupValues[3].padEnd(3,'0').take(3).toLongOrNull() ?: 0
                val total = min*60*1000 + sec*1000 + msPart
                lines.add(LrcLine(total, text))
            }
        }
        return lines.sortedBy { it.timestampMs }
    }
    fun findCurrentIndex(lines: List<LrcLine>, positionMs: Long): Int {
        return lines.indexOfLast { it.timestampMs <= positionMs }.coerceAtLeast(0)
    }
}
