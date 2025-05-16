package com.example.admobadssdk.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.admobadssdk.R

@Composable
fun BaseButton(
    text: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(horizontal = 30.dp, vertical = 6.dp)
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(id = R.color.primary_color)
        )
    ) {
        Text(text = text)
    }
}
