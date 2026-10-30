package com.vexmusic.player.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

object VexColors {
    val Primary = Color(0xFFA855F7)
    val PrimaryVariant = Color(0xFF9333EA)
    val Background = Color(0xFF0F0F13)
    val Surface = Color(0xFF17171D)
    val Card = Color(0xFF1C1B23)
    val TextPrimary = Color(0xFFFFFFFF)
    val TextSecondary = Color(0xFFA1A1AA)
    val Success = Color(0xFF22C55E)
    val Error = Color(0xFFEF4444)
}

data class VexColorPalette(
    val primary: Color = VexColors.Primary,
    val background: Color = VexColors.Background,
    val surface: Color = VexColors.Surface,
    val card: Color = VexColors.Card
)

object VexMusicTheme {
    val colors = VexColorPalette()
    val shapes = Shapes(
        small = RoundedCornerShape(10.dp),
        medium = RoundedCornerShape(16.dp),
        large = RoundedCornerShape(24.dp),
        extraLarge = RoundedCornerShape(28.dp)
    )
}

@Composable
fun VexMusicTheme(content: @Composable () -> Unit) {
    val scheme = darkColorScheme(
        primary = VexColors.Primary,
        background = VexColors.Background,
        surface = VexColors.Surface,
        onBackground = Color.White,
        onSurface = Color.White,
        surfaceVariant = VexColors.Card
    )
    MaterialTheme(colorScheme = scheme, typography = Typography(
        titleLarge = TextStyle(fontSize = 22.sp, fontWeight = FontWeight.Bold, color = Color.White),
        bodyMedium = TextStyle(fontSize = 14.sp, color = VexColors.TextSecondary)
    ), content = content)
}
