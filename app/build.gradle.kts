plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)

    id("com.google.gms.google-services") // 👈 Plugin google-services

    id("com.google.devtools.ksp") // ksp for Room Data

}


android {
    namespace = "com.android.chefshare"
    compileSdk = 35

    buildFeatures {
        viewBinding = true
    }

    defaultConfig {
        applicationId = "com.android.chefshare"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
        vectorDrawables.useSupportLibrary = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        jvmTarget = "17"
    }
}

dependencies {
    //Gson
    implementation("com.google.code.gson:gson:2.10.1")

    //coroutin + lifecycle
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")

    // Core & UI
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation (libs.retrofit)
    implementation (libs.converter.gson)

    // Room Data
    ksp(libs.androidx.room.compiler)
    implementation(libs.androidx.room.runtime)
    // Firebase Auth
    implementation(libs.firebase.auth)

    // Google Sign-In;
    implementation(libs.play.services.auth)

    // Glide
    implementation(libs.glide)
    annotationProcessor(libs.compiler)
    // CardView
    implementation("androidx.cardview:cardview:1.0.0")

    // Navigation
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation (libs.circleimageview)

    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
