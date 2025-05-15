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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomeScreen(
    onBannerClick: () -> Unit = {},
    onAdaptiveBannerClick: () -> Unit = {},
    onCollapsibleBannerClick: () -> Unit = {},
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 16.dp),
        verticalArrangement = Arrangement.Top
    ) {

        Text(
            text = "Home",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = { onBannerClick() },
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 6.dp)
                .fillMaxWidth()
        ) {
            Text(text =  "Show Banner Ad" )
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = { onAdaptiveBannerClick() },
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 6.dp)
                .fillMaxWidth()
        ) {
            Text(text =  "Show Adaptive Banner Ad" )
        }

        Spacer(modifier = Modifier.height(12.dp))


        Button(
            onClick = {  },
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 6.dp)
                .fillMaxWidth()
        ) {
            Text(text =  "Show Interstitial Ad" )
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = { },
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 6.dp)
                .fillMaxWidth()
        ) {
            Text(text =  "Show Reward Ad" )
        }
        Spacer(modifier = Modifier.height(12.dp))


        Button(
            onClick = {  },
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 6.dp)
                .fillMaxWidth()
        ) {
            Text(text =  "Show Reward Interstitial Ad" )
        }

        Spacer(modifier = Modifier.height(12.dp))


        Button(
            onClick = { },
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 6.dp)
                .fillMaxWidth()
        ) {
            Text(text =    "Show Recycler Native Ad" )
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = { onCollapsibleBannerClick()},
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 6.dp)
                .fillMaxWidth()
        ) {
            Text(text =  "Show Collapsible Banner" )
        }

    }
}

