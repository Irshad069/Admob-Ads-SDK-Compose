package com.example.admobadssdk

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.admobadssdk.navigation.AppNavigation
import com.example.admobadssdk.ui.theme.AdmobAdsSDKTheme
import com.example.sdkads.AdSdkInitializer

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AdmobAdsSDKTheme {
               AppNavigation()
                AdSdkInitializer.handleConsent(this) { consentGiven ->
                    Log.d("TAG", "Consent given: $consentGiven")
                }
            }
        }
    }
}


