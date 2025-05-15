package com.example.admobadssdk.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Screen {

    @Serializable
    data object HomeDisplay: Screen()

    @Serializable
    data object BannerDisplay: Screen()

    @Serializable
    data object AdaptiveBannerDisplay: Screen()

}