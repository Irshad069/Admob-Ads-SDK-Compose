package com.example.sdkads.nativead

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.sdkads.R
import kotlin.math.roundToInt

@Composable
fun RatingBar(rating: Float) {
    Row {
        repeat(5) { index ->
            val imageRes = if (index < rating.roundToInt()) {
                R.drawable.ic_star
            } else {
                R.drawable.ic_star_border
            }
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = null,
                modifier = Modifier.size(16.dp)
            )
        }
    }

}
