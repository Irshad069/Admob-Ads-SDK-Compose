package com.example.admobadssdk.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.admobadssdk.R
import com.example.admobadssdk.components.AppBar
import com.example.sdkads.listnative.NativeAdList
import com.example.sdkads.nativead.NativeAdSize

@Composable
fun ListNativeScreen() {

    val items = remember {
        List(30) { "Item #${it + 1}" }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        AppBar(title = stringResource(R.string.showing_lv_native_ad))

        NativeAdList(
            items = items,
            frequency = 5,
            adSize = NativeAdSize.MEDIUM
        ) { item ->

            androidx.compose.material3.Text(
                text = item,
                modifier = Modifier
                    .padding(16.dp)
            )
        }
    }
}
