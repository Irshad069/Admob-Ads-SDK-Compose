package com.example.admobadssdk.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.admobadssdk.R
import com.example.admobadssdk.components.AppBar
import com.example.sdkads.collapsiblebanner.CollapsibleBannerAdView

@Composable
fun CollapsibleBannerScreen() {

    Column(modifier = Modifier.fillMaxSize()) {
        AppBar(title = stringResource(R.string.showing_collapsible_banner_ad))
        Spacer(modifier = Modifier.weight(1f))
        Box(modifier = Modifier.fillMaxWidth()) {
            CollapsibleBannerAdView()
        }
    }

}

