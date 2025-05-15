package com.example.admobadssdk.presentation

import android.app.Activity
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.sdkads.interstitial.InterstitialHelper

@Composable
fun InterstitialScreen() {
    val context = LocalContext.current
    val activity = context as? Activity

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Showing Interstitial Ad",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {
                activity?.let {
                    InterstitialHelper.showAd(it) {
                        Log.d("TAG", "Ad closed. Proceeding...")
                    }
                }
            },
            modifier = Modifier.align(alignment = androidx.compose.ui.Alignment.CenterHorizontally)
        ) {
            Text("Show Interstitial Ad")
        }
    }
}
