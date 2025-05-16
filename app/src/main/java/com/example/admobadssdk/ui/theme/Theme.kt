package com.example.admobadssdk.ui.theme

import android.app.Activity
import android.os.Build
import android.view.WindowInsetsController
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40
)

@Composable
fun AdmobAdsSDKTheme(
    content: @Composable () -> Unit
) {
    val statusBarColor = Color.White
    val view = LocalView.current
    val activity = view.context as? Activity

    DisposableEffect(Unit) {
        activity?.window?.let { window ->
            window.statusBarColor = statusBarColor.toArgb()

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {

                window.insetsController?.setSystemBarsAppearance(
                    WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS,
                    WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
                )
            } else {
                window.decorView.systemUiVisibility =
                    window.decorView.systemUiVisibility or
                            android.view.View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            }
        }
        onDispose { }
    }

    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = Typography,
        content = content
    )
}