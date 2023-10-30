plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-parcelize")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}


android {
    namespace = "com.caseaplikasi.mobileapp.pembayaranqris"
    compileSdk =  ConfigData.compileSdkVersion

    defaultConfig {
        applicationId = "com.caseaplikasi.mobileapp.pembayaranqris"
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation (project(":core"))
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.7.2")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    implementation ("androidx.camera:camera-camera2:1.4.0-alpha01")
    implementation ("androidx.camera:camera-lifecycle:1.4.0-alpha01")
    implementation ("androidx.camera:camera-view:1.4.0-alpha01")
    implementation ("com.google.mlkit:barcode-scanning:17.2.0")
    implementation ("com.google.accompanist:accompanist-permissions:0.19.0")

    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2")
    implementation ("androidx.navigation:navigation-compose:2.7.4")
    androidTestImplementation ("androidx.navigation:navigation-testing:2.7.4")

    implementation(Deps.core)
    implementation(Deps.appCompat)
    implementation (Deps.daggerHilt)
    kapt (Deps.daggerHiltCompiler)
    implementation (Deps.roomRuntime)
    kapt (Deps.roomCompiler)
    implementation (Deps.coroutinesCore)
    implementation (Deps.coroutines)
    implementation (Deps.room)
    api (Deps.lifeData)
    implementation (Deps.timber)
    implementation (Deps.retrofit)
    implementation (Deps.retrofitGson)
    implementation (Deps.retrofitMoshi)
    implementation (Deps.retrofitRxJava)
    implementation (Deps.okhttp3Logging)
    implementation (Deps.okhttp3)
    implementation (Deps.sqlCipher)
    implementation (Deps.sqlite)
    implementation (Deps.lottie)
}