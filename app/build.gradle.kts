plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = Configs.packageName
    compileSdk = Configs.compileSDK

    defaultConfig {
        applicationId = Configs.packageName
        minSdk = Configs.minSDK
        targetSdk = Configs.targetSDK
        versionCode = Configs.versionCode
        versionName = Configs.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = Configs.useSupportLibrary
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = Configs.isMinifyEnabled
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = Configs.jvmTarget
    }
    buildFeatures {
        compose = Configs.compose
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Configs.kotlinCompilerExtensionVersion
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.compose.boom))
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.graphics)
    implementation(libs.compose.ui.preview)
    implementation(libs.compose.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.compose.boom))
    androidTestImplementation(libs.compose.ui.testing.junit)
    debugImplementation(libs.compose.ui.tooling)
    debugImplementation(libs.compose.ui.test.manifest)
}