package com.example.admobadssdk.presentation

import android.app.Activity
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.example.admobadssdk.R
import com.example.admobadssdk.components.AppBar
import com.example.admobadssdk.components.BaseButton
import com.example.sdkads.rewardinterstitial.RewardedInterstitialHelper

@Composable
fun RewardInterstitialScreen() {
    val context = LocalContext.current
    val activity = context as? Activity

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        AppBar(title = stringResource(R.string.showing_reward_interstitial_ad))
        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f),
            verticalArrangement = Arrangement.Center
        ) {
            BaseButton(
                text = stringResource(R.string.show_reward_interstitial_ad),
                onClick = {
                    activity?.let {
                        RewardedInterstitialHelper.showAd(
                            activity = it,
                            onAdClosed = {
                                Log.d("AdDemo", "Ad was dismissed.")
                            },
                            onUserEarnedReward = { rewardAmount, rewardType ->
                                Log.d("AdDemo", "User earned $rewardAmount $rewardType.")
                            }
                        )
                    }
                }
            )
        }
    }
}
