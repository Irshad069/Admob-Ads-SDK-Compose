package com.example.sdkads.nativead

import android.util.Log
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import com.example.sdkads.core.AdsConfig
import com.google.android.gms.ads.*
import com.google.android.gms.ads.nativead.NativeAd
import com.google.android.gms.ads.nativead.NativeAdOptions

enum class NativeAdSize {
    MEDIUM, LARGE
}

@Composable
fun NativeAdViewCompose(
    adSize: NativeAdSize = NativeAdSize.LARGE
) {
    val context = LocalContext.current
    var nativeAd by remember { mutableStateOf<NativeAd?>(null) }

    DisposableEffect(Unit) {
        val adLoader = AdLoader.Builder(context, AdsConfig.NATIVE_AD_ID)
            .forNativeAd { ad ->
                nativeAd?.destroy() // Clean up any previously loaded ad
                nativeAd = ad
            }
            .withAdListener(object : AdListener() {
                override fun onAdFailedToLoad(adError: LoadAdError) {
                    Log.e("NativeAd", "Failed to load native ad: ${adError.message}")
                }
            })
            .withNativeAdOptions(
                NativeAdOptions.Builder()
                    .setRequestMultipleImages(false)
                    .build()
            )
            .build()

        adLoader.loadAd(AdRequest.Builder().build())

        onDispose {
            nativeAd?.destroy()
            nativeAd = null
        }
    }

    nativeAd?.let {
        when (adSize) {
            NativeAdSize.LARGE -> LargeNativeAdView(it)
            NativeAdSize.MEDIUM -> MediumNativeAdView(it)
        }
    }
}
