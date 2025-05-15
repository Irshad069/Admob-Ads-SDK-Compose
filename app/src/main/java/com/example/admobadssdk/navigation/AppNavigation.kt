package com.example.admobadssdk.navigation

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.admobadssdk.presentation.AdaptiveBannerScreen
import com.example.admobadssdk.presentation.BannerScreen
import com.example.admobadssdk.presentation.CollapsibleBannerScreen
import com.example.admobadssdk.presentation.HomeScreen


@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    Surface(color = MaterialTheme.colorScheme.background) {
        NavHost(
            navController = navController,
            startDestination = Screen.HomeDisplay
        ) {
            composable<Screen.HomeDisplay> {
                HomeScreen(
                    onBannerClick = { navController.navigate(Screen.BannerDisplay) },
                    onAdaptiveBannerClick = { navController.navigate(Screen.AdaptiveBannerDisplay) },
                    onCollapsibleBannerClick = { navController.navigate(Screen.CollapsibleBannerDisplay) }
                )
            }
            composable<Screen.BannerDisplay> {
                BannerScreen()
            }
            composable<Screen.AdaptiveBannerDisplay> {
                AdaptiveBannerScreen()
            }
            composable<Screen.CollapsibleBannerDisplay> {
                CollapsibleBannerScreen()
            }
        }
    }
}
