package com.example.sdkads.nativead

import android.view.View
import android.widget.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.example.sdkads.extension.toBitmap
import com.google.android.gms.ads.nativead.NativeAd
import com.google.android.gms.ads.nativead.NativeAdView

@Composable
fun MediumNativeAdView(nativeAd: NativeAd, modifier: Modifier = Modifier) {
    val context = androidx.compose.ui.platform.LocalContext.current

    AndroidView(
        factory = {
            val adView = NativeAdView(context)

            // Icon ImageView
            val iconView = ImageView(context).apply {
                id = View.generateViewId()
                nativeAd.icon?.drawable?.let { setImageDrawable(it) }
                layoutParams = LinearLayout.LayoutParams(100, 100).apply {
                    setMargins(0, 0, 16, 0)
                }
            }

            // Headline TextView
            val headlineView = TextView(context).apply {
                id = View.generateViewId()
                text = nativeAd.headline
                textSize = 18f
                setTextColor(android.graphics.Color.BLACK)
            }

            // Advertiser TextView
            val advertiserView = TextView(context).apply {
                id = View.generateViewId()
                text = nativeAd.advertiser
                textSize = 14f
                setTextColor(android.graphics.Color.DKGRAY)
            }

            // Body TextView
            val bodyView = TextView(context).apply {
                id = View.generateViewId()
                text = nativeAd.body
                textSize = 14f
                setTextColor(android.graphics.Color.DKGRAY)
            }

            // Call to Action Button
            val callToActionView = Button(context).apply {
                id = View.generateViewId()
                text = nativeAd.callToAction
            }

            // Vertical LinearLayout container
            val verticalLayout = LinearLayout(context).apply {
                orientation = LinearLayout.VERTICAL
                setPadding(16, 16, 16, 16)
                setBackgroundColor(android.graphics.Color.WHITE)

                addView(headlineView)
                addView(advertiserView)
                addView(bodyView)
                addView(callToActionView)
            }

            // Horizontal LinearLayout container for icon + texts
            val horizontalLayout = LinearLayout(context).apply {
                orientation = LinearLayout.HORIZONTAL
                addView(iconView)
                addView(verticalLayout, LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ))
            }

            // Add horizontal layout to NativeAdView
            adView.addView(horizontalLayout)

            // Set required views for NativeAdView
            adView.headlineView = headlineView
            adView.iconView = iconView
            adView.advertiserView = advertiserView
            adView.bodyView = bodyView
            adView.callToActionView = callToActionView

            // Bind native ad
            adView.setNativeAd(nativeAd)

            adView
        },
        modifier = modifier
    )
}
