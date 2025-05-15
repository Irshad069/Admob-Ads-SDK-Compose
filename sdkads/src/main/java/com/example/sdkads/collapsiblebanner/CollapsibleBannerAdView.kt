package com.example.sdkads.collapsiblebanner

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.os.Bundle
import android.util.DisplayMetrics
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.viewinterop.AndroidView
import com.example.sdkads.core.AdsConfig
import com.google.ads.mediation.admob.AdMobAdapter
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView

/**
 * Created by Irshad khan
 * Date: 15/05/2025$
 */

/**
 * Official collapsible banner using Google AdMob SDK via AdMobAdapter extras.
 * No parameters needed. Handles adaptive sizing and lifecycle properly.
 */
@Composable
fun CollapsibleBannerAdView() {
    val context = LocalContext.current

    // Skip in preview mode to avoid crashes
    if (LocalInspectionMode.current) return

    // Resolve Activity from context for adaptive sizing
    val activity = context.findActivity() ?: return

    // Create and remember AdView
    val adView = remember {
        AdView(context).apply {
            adUnitId = AdsConfig.COLLAPSIBLE_BANNER_ID
            setAdSize(activity.getAdaptiveBannerAdSize())

            // Pass AdMob-specific extras for collapsible behavior
            val extras = Bundle().apply {
                putString("collapsible", "bottom")
            }

            val adRequest = AdRequest.Builder()
                .addNetworkExtrasBundle(AdMobAdapter::class.java, extras)
                .build()

            loadAd(adRequest)
        }
    }

    // Compose wrapper for AdView
    AndroidView(
        factory = { adView }
    )

    // Clean up the ad view properly
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
