package com.example.admobadssdk.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.admobadssdk.R

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
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 16.dp),
        verticalArrangement = Arrangement.Top
    ) {

        Button(
            onClick = { onBannerClick() },
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 6.dp)
                .fillMaxWidth()
        ) {
            Text(text = stringResource(R.string.showing_banner_ad))
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = { onAdaptiveBannerClick() },
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 6.dp)
                .fillMaxWidth()
        ) {
            Text(text = stringResource(R.string.showing_adaptive_banner_ad) )
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = {
                onInterstitialBannerClick()
            },
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 6.dp)
                .fillMaxWidth()
        ) {
            Text(text = stringResource(R.string.show_interstitial_banner_ad) )
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = { onRewardBannerClick() },
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 6.dp)
                .fillMaxWidth()
        ) {
            Text(text =  stringResource(R.string.show_reward_banner_ad) )
        }
        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = { onRewardInterstitialBannerClick() },
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 6.dp)
                .fillMaxWidth()
        ) {
            Text(text = stringResource(R.string.show_reward_interstitial_banner_ad))
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = { },
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 6.dp)
                .fillMaxWidth()
        ) {
            Text(text =stringResource(R.string.show_native_banner_ad))
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = { },
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 6.dp)
                .fillMaxWidth()
        ) {
            Text(text =stringResource(R.string.show_recycler_naive_banner_ad))
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = { onCollapsibleBannerClick() },
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 6.dp)
                .fillMaxWidth()
        ) {
            Text(text = stringResource(R.string.showing_collapsible_banner_ad))
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = { onNativeAdClick()},
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 6.dp)
                .fillMaxWidth()
        ) {
            Text(text = "Show Native Ad")
        }

    }
}

