plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.example.admobadssdk"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.admobadssdk"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        debug {
            buildConfigField(
                "String",
                "BANNER_ID",
                "\"ca-app-pub-3940256099942544/6300978111\""
            ) // Test Id in debug builds
            buildConfigField(
                "String",
                "INTERSTITIAL_AD_ID",
                "\"ca-app-pub-3940256099942544/1033173712\""
            ) // Test Id in debug builds
            buildConfigField(
                "String",
                "ADAPTIVE_BANNER_ID",
                "\"ca-app-pub-3940256099942544/9214589741\""
            ) // Test Id in debug builds
            buildConfigField(
                "String",
                "REWARD_INTERSTITIAL_AD_ID",
                "\"ca-app-pub-3940256099942544/5354046379\""
            ) // Test Id in debug builds
            buildConfigField(
                "String",
                "REWARDED_AD_ID",
                "\"ca-app-pub-3940256099942544/5224354917\""
            ) // Test Id in debug builds
            buildConfigField(
                "String",
                "NATIVE_AD_ID",
                "\"ca-app-pub-3940256099942544/2247696110\""
            ) // Test Id in debug builds
            buildConfigField(
                "String",
                "APP_OPEN_ID",
                "\"ca-app-pub-3940256099942544/9257395921\""
            ) // Test Id in debug builds
            buildConfigField(
                "String",
                "COLLAPSIBLE_BANNER_ID",
                "\"ca-app-pub-3940256099942544/2014213617\""
            ) // Test Id in debug builds
        }
        release {
            isMinifyEnabled = false
            buildConfigField(
                "String",
                "BANNER_ID",
                "\"your-production-banner-id\""
            ) //Add original Id
            buildConfigField(
                "String",
                "INTERSTITIAL_AD_ID",
                "\"your-production-interstitial-id\""
            ) //Add original Id
            buildConfigField(
                "String",
                "ADAPTIVE_BANNER_ID",
                "\"your-production-adaptive-banner-id\""
            ) //Add original Id
            buildConfigField(
                "String",
                "REWARD_INTERSTITIAL_AD_ID",
                "\"your-production-reward-interstitial-id\""
            ) //Add original Id
            buildConfigField(
                "String",
                "REWARDED_AD_ID",
                "\"your-production-reward-ad-id\""
            ) //Add original Id
            buildConfigField(
                "String",
                "NATIVE_AD_ID",
                "\"your-production-native-id\""
            ) //Add original Id
            buildConfigField(
                "String",
                "APP_OPEN_ID",
                "\"your-production-app-open-id\""
            ) //Add original Id
            buildConfigField(
                "String",
                "COLLAPSIBLE_BANNER_ID",
                "\"your-production-collapsible_banner-id\""
            ) //Add original Id
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
      /*  release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }*/
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        buildConfig = true
        compose = true
    }
}

dependencies {
    implementation(project(":sdkads"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)


    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.navigation.testing)
    implementation(libs.kotlinx.serialization)
}