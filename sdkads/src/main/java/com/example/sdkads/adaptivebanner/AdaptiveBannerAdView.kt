package com.example.sdkads.adaptivebanner

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.util.DisplayMetrics
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.viewinterop.AndroidView
import com.example.sdkads.core.AdsConfig
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView

/**
 * Created by Irshad khan
 * Date: 15/05/2025$
 */

/**
 * AdaptiveBannerAdView displays an adaptive banner ad from Google Mobile Ads.
 * It safely handles Compose preview mode and lifecycle disposal.
 *
 * @param modifier Modifier to style the AdView composable
 */

@Composable
fun AdaptiveBannerAdView(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    // Don't load ads in Preview Mode to avoid crashes
    if (LocalInspectionMode.current) {
        // Optionally show a placeholder in preview mode
        return
    }

    // Find the hosting Activity from Context, required for AdSize calculation
    val activity = context.findActivity() ?: return

    // Remember AdView instance, to keep it stable across recompositions
    val adView = remember {
        AdView(context).apply {
            adUnitId = AdsConfig.ADAPTIVE_BANNER_ID
            setAdSize(activity.getAdaptiveBannerAdSize())
        }
    }

    // Load ad when this composable enters composition or when adView changes
    LaunchedEffect(adView) {
        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)
    }

    // Compose UI integration for the AdView
    AndroidView(
        factory = { adView },
        modifier = modifier
    )

    // Clean up the AdView to prevent memory leaks when this composable leaves the composition
    DisposableEffect(adView) {
        onDispose {
            adView.destroy()
        }
    }
}

/**
 * Calculate the adaptive banner size based on the Activity's current screen width.
 */
fun Activity.getAdaptiveBannerAdSize(): AdSize {
    val displayMetrics = DisplayMetrics()
    windowManager.defaultDisplay.getMetrics(displayMetrics)

    val density = displayMetrics.density
    val adWidthPixels = displayMetrics.widthPixels.toFloat()
    val adWidthDp = (adWidthPixels / density).toInt()

    return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(this, adWidthDp)
}

/**
 * Safely unwrap Activity from Context or ContextWrapper.
 */
fun Context.findActivity(): Activity? = when (this) {
    is Activity -> this
    is ContextWrapper -> baseContext.findActivity()
    else -> null
}
