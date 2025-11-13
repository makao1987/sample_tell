plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.hilt.android)   // ← Hilt をここに移動
    alias(libs.plugins.ksp)            // ← KSP と同じスコープに
}

android {
    namespace = "com.example.sample_tell"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.sample_tell"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        compose = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlin {
        compilerOptions {
            jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
        }
    }
}

dependencies {
    // AndroidX 基本
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)

    // Hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)

    // Room
    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    ksp(libs.room.compiler)

    // Compose
    implementation(libs.compose.ui)
    implementation(libs.compose.material3)
    implementation(libs.compose.runtime)
    implementation(libs.compose.ui.tooling) // Changed from debugImplementation

    // Navigation
    implementation(libs.navigation.compose)
    // Jitsi SDK
    implementation(libs.jitsi.meet.sdk)
    implementation("androidx.hilt:hilt-navigation-compose:1.1.0") // ← これが必要
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0") // ViewModel連携
    // Testing
    testImplementation(libs.junit)
}
