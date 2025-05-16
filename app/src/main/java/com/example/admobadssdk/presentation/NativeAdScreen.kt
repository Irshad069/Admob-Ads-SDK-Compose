package com.example.admobadssdk.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.admobadssdk.R
import com.example.admobadssdk.components.AppBar
import com.example.sdkads.nativead.NativeAdSize
import com.example.sdkads.nativead.NativeAdViewCompose

@Composable
fun NativeAdScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        AppBar(title = stringResource(R.string.showing_native_ad))
        Spacer(modifier = Modifier.weight(1f))
        Column {
//                NativeAdViewCompose(adSize = NativeAdSize.LARGE)
            NativeAdViewCompose(adSize = NativeAdSize.MEDIUM)
        }
    }
}
