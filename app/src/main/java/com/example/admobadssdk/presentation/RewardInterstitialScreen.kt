package com.example.admobadssdk.presentation


import android.app.Activity
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.sdkads.rewardinterstitial.RewardedInterstitialHelper

@Composable
fun RewardInterstitialScreen() {
    val context = LocalContext.current
    val activity = context as? Activity

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Showing Reward Interstitial Ad",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
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
        ) {
            Text("Show Reward Interstitial Ad")
        }
    }
}
