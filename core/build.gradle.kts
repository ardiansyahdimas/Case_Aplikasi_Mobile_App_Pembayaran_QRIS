plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-parcelize")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.caseaplikasi.core"
    compileSdk =  ConfigData.compileSdkVersion

    defaultConfig {
        minSdk = ConfigData.minSdkVersion

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {
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
    implementation ("androidx.navigation:navigation-compose:2.6.0")
}