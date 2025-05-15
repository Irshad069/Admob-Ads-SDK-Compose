package com.example.sdkads.nativead

import android.R
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.sdkads.extension.toBitmap
import com.google.android.gms.ads.nativead.MediaView
import com.google.android.gms.ads.nativead.NativeAd
import com.google.android.gms.ads.nativead.NativeAdView

@Composable
fun LargeNativeAdView(nativeAd: NativeAd, modifier: Modifier = Modifier) {
    val context = LocalContext.current

    AndroidView(
        factory = {
            val adView = NativeAdView(context)

            // Create MediaView
            val mediaView = MediaView(context).apply {
                id = View.generateViewId()
            }

            // Create TextView for headline
            val headlineView = TextView(context).apply {
                id = View.generateViewId()
                text = nativeAd.headline
                textSize = 18f
                setTextColor(android.graphics.Color.BLACK)
            }

            // Create Button for CTA
            val callToActionView = android.widget.Button(context).apply {
                id = View.generateViewId()
                text = nativeAd.callToAction
            }

            // Add views to layout
            val layout = LinearLayout(context).apply {
                orientation = LinearLayout.VERTICAL
                setPadding(16, 16, 16, 16)
                setBackgroundColor(android.graphics.Color.WHITE)

                addView(headlineView)
                addView(mediaView, LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    300
                ))
                addView(callToActionView)
            }

            // Set views to NativeAdView
            adView.headlineView = headlineView
            adView.mediaView = mediaView
            adView.callToActionView = callToActionView

            adView.addView(layout)

            // Bind the native ad (must be last)
            adView.setNativeAd(nativeAd)

            adView
        },
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
    )
}

