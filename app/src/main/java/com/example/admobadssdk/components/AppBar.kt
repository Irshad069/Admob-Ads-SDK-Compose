package com.example.admobadssdk.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.admobadssdk.R

@Composable
fun AppBar(title: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(colorResource(id = R.color.primary_color))
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = title,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = android.R.color.white)
        )
    }
}
