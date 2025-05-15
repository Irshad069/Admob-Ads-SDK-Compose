package com.example.sdkads.fixedsizebanner

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.unit.dp
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
 * Fixed size Banner Ad Composable with Google Mobile Ads SDK.
 *
 * @param modifier Modifier for styling the AdView container.
 */
@Composable
fun BannerAdView(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    // Preview mode — no ad loading
    if (LocalInspectionMode.current) return

    val adUnitId = AdsConfig.BANNER_ID

    // Find the Activity from the context, needed for lifecycle safety if you want
    val adView = remember {
        AdView(context).apply {
            setAdSize(AdSize.BANNER)
            this.adUnitId = adUnitId
            // Load ad here, after setting adUnitId and adSize
            loadAd(AdRequest.Builder().build())
        }
    }

    AndroidView(
        factory = { adView },
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp)
    )

    DisposableEffect(adView) {
        onDispose {
            adView.destroy()
        }
    }
}
