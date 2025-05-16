package com.example.sdkads.listnative

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.sdkads.nativead.NativeAdSize
import com.example.sdkads.nativead.NativeAdViewCompose

/**
 * Created by Irshad khan
 * Date: 15/05/2025$
 */

/**
 * Generic LazyColumn list that injects a NativeAd every [frequency] items.
 *
 * @param items The list of items to display.
 * @param frequency The interval at which to insert a NativeAd.
 * @param adSize The size of the native ad to display.
 * @param itemContent Composable for displaying an individual item.
 */
@Composable
fun <T> NativeAdList(
    items: List<T>,
    frequency: Int = 5,
    adSize: NativeAdSize = NativeAdSize.MEDIUM,
    itemContent: @Composable (T) -> Unit
) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        itemsIndexed(items) { index, item ->
            // Show the regular item
            itemContent(item)

            // Show the ad after every [frequency] items
            if ((index + 1) % frequency == 0) {
                Spacer(modifier = Modifier.height(8.dp))
                NativeAdViewCompose(adSize = adSize)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}
