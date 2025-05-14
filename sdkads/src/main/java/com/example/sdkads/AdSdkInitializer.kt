package com.example.sdkads
import android.app.Activity
import android.app.Application
import android.util.Log
import com.example.sdkads.appopen.AppOpenAdHelper
import com.example.sdkads.consent.ConsentManager
import com.example.sdkads.core.AdsConfig
import com.example.sdkads.interstitial.InterstitialHelper
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.RequestConfiguration

object AdSdkInitializer {

    private var appOpenAdHelper: AppOpenAdHelper? = null

    private var isInterstitialLoaded = false

    fun initialize(
        application: Application,
        isDebug: Boolean,
        testDeviceIds: List<String> = emptyList(),
        bannerId: String = "",
        appOpenAd: String = "",
        interstitialAd: String = "",
        adaptiveBannerAd: String = "",
        rewardInterstitialAd: String = "",
        rewardAd: String = "",
        nativeAd: String = "",
        collapsibleBannerAd: String = "",
        excludedActivities: List<String> = emptyList()
    ) {
        // Set test device IDs for AdMob
        MobileAds.setRequestConfiguration(
            RequestConfiguration.Builder()
                .setTestDeviceIds(testDeviceIds)
                .build()
        )

        AdsConfig.BANNER_ID = bannerId
        AdsConfig.APP_OPEN_ID = appOpenAd
        AdsConfig.IS_DEBUG = isDebug
        AdsConfig.INTERSTITIAL_AD_ID = interstitialAd
        AdsConfig.ADAPTIVE_BANNER_ID = adaptiveBannerAd
        AdsConfig.REWARD_INTERSTITIAL_AD_ID = rewardInterstitialAd
        AdsConfig.REWARDED_AD_ID = rewardAd
        AdsConfig.NATIVE_AD_ID = nativeAd
        AdsConfig.COLLAPSIBLE_BANNER_ID = collapsibleBannerAd

        // Initialize Google Mobile Ads SDK
        MobileAds.initialize(application) {
            // Once initialized, load interstitial ads if not already loaded

            if (!isInterstitialLoaded) {
                isInterstitialLoaded = true
                // Load the ad after MobileAds initialized
                Log.e("TAG", "initialize: before load" )
                InterstitialHelper.initLoadAd(application)
                Log.e("TAG", "initialize: after load")
            }
        }

        // Setup App Open ad handler with excluded activities
        appOpenAdHelper = AppOpenAdHelper(application, excludedActivities)
    }

    fun handleConsent(activity: Activity, onConsentResult: (Boolean) -> Unit) {
        ConsentManager.requestConsent(activity) { consentGiven ->
            onConsentResult(consentGiven)
        }
    }
}
