package com.example.admobadssdk.presentation

import android.app.Activity
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.sdkads.reward.RewardedAdHelper

@Composable
fun RewardScreen() {
    val context = LocalContext.current
    val activity = context as? Activity

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Showing Reward Ad",
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(48.dp))

        Button(onClick = {
            activity?.let {
                RewardedAdHelper.showAd(
                    activity = it,
                    onAdClosed = {
                        Log.d("AdDemo", "Ad was dismissed.")
                    },
                    onUserEarnedReward = { rewardAmount, rewardType ->
                        Log.d("AdDemo", "User earned $rewardAmount $rewardType.")
                    }
                )
            }
        }) {
            Text("Show Reward Ad")
        }
    }
}
