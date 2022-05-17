plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-kapt")
    //id("com.google.gms.google-services")
}

android {
    compileSdk = 31
    defaultConfig {
        applicationId = "com.rafavs.gymcompose"
        minSdk = 28
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
        javaCompileOptions {
            annotationProcessorOptions {
                argument("room.schemaLocation", "$projectDir/schemas")
                argument("room.incremental", "true")
            }
        }
    }

    signingConfigs {
        register("release") {
            storePassword = "banana"
            keyAlias = "banana"
            keyPassword = "banana"
            storeFile = file("../certs/fakeRelease.keystore")
        }
        named("debug") {
            storeFile = file("../certs/debug.keystore")
        }
    }

    buildTypes {
        release {
            signingConfig = signingConfigs["release"]
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
        named("debug") {
            applicationIdSuffix = ".debug"
            signingConfig = signingConfigs["debug"]
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.1.1"
    }
}

dependencies {
    implementation(libs.coroutines.android)
    implementation(libs.coroutines.playServices)

    implementation(libs.androidx.coreKtx)
    implementation(libs.androidx.appcompat)

    //implementation("com.google.firebase:firebase-bom:29.0.4")
    //implementation("com.google.firebase:firebase-firestore-ktx:24.0.1")
    //implementation("com.google.firebase:firebase-auth-ktx:21.0.1")
    //implementation("com.google.android.gms:play-services-auth:20.1.0")


    implementation(libs.compose.ui)
    implementation(libs.compose.material)
    implementation(libs.compose.tooling)
    implementation(libs.compose.material)
    implementation(libs.compose.materialIcons)
    implementation(libs.compose.activity)
//  implementation(libs.compose.viewmodel)
    implementation(libs.compose.navigation)

    //implementation(libs.room.runtime)
    //implementation(libs.room.ktx)
    //kapt(libs.room.compiler)

    implementation(libs.lifecycle.runtimeKtx)
    implementation(libs.lifecycle.viewmodelKtx)

    //implementation(libs.koin.android)
    //implementation(libs.koin.compose)
    //implementation(libs.koin.cokoin)
    //implementation(libs.koin.cokoinViewmodel)

    testImplementation(libs.junit)
}