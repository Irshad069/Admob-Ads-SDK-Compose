package com.example.admobadssdk.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.admobadssdk.R
import com.example.admobadssdk.components.AppBar
import com.example.admobadssdk.components.BaseButton

@Composable
fun HomeScreen(
    onBannerClick: () -> Unit = {},
    onAdaptiveBannerClick: () -> Unit = {},
    onCollapsibleBannerClick: () -> Unit = {},
    onInterstitialBannerClick: () -> Unit = {},
    onRewardBannerClick: () -> Unit = {},
    onRewardInterstitialBannerClick: () -> Unit = {},
    onNativeAdClick: () -> Unit = {},
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top
    ) {

        AppBar(title = stringResource(R.string.home_screen))

        Spacer(modifier = Modifier.height(20.dp))

        BaseButton(
            text = stringResource(R.string.showing_banner_ad),
            onClick = onBannerClick
        )

        BaseButton(
            text = stringResource(R.string.showing_adaptive_banner_ad),
            onClick = onAdaptiveBannerClick
        )

        BaseButton(
            text = stringResource(R.string.show_interstitial_ad),
            onClick = onInterstitialBannerClick
        )

        BaseButton(
            text = stringResource(R.string.show_reward_ad),
            onClick = onRewardBannerClick
        )

        BaseButton(
            text = stringResource(R.string.show_reward_interstitial_ad),
            onClick = onRewardInterstitialBannerClick
        )

        BaseButton(
            text = stringResource(R.string.show_lv_native_ad),
            onClick = {}
        )

        BaseButton(
            text = stringResource(R.string.show_collapsible_banner_ad),
            onClick = onCollapsibleBannerClick
        )

        BaseButton(
            text = stringResource(R.string.show_native_ad),
            onClick = onNativeAdClick
        )

    }
}

