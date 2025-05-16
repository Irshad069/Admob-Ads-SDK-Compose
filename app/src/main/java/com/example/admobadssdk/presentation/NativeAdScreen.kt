package com.example.admobadssdk.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.admobadssdk.R
import com.example.sdkads.nativead.NativeAdSize
import com.example.sdkads.nativead.NativeAdViewCompose

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NativeAdScreen() {
    Box(modifier = Modifier.fillMaxSize()) {

        TopAppBar(
            title = { Text(text = stringResource(R.string.showing_native_ad)) }
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
        ) {
            Column {
//                NativeAdViewCompose(adSize = NativeAdSize.LARGE)
                NativeAdViewCompose(adSize = NativeAdSize.MEDIUM)
            }
        }
    }
}