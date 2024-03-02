plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.example.noteapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.noteapp"
        minSdk = 29
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

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
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    //dagger-hilt
    val hiltVers = "2.50"
    implementation("com.google.dagger:hilt-android:$hiltVers")
    implementation("com.google.dagger:hilt-android-gradle-plugin:$hiltVers")
    ksp("com.google.dagger:hilt-compiler:$hiltVers")
    ksp("androidx.hilt:hilt-compiler:1.2.0") // 1.0.0 in course
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")

    //Room
    val roomVers = "2.6.1"
    implementation("androidx.room:room-runtime:$roomVers")
    annotationProcessor("androidx.room:room-compiler:$roomVers")
    ksp("androidx.room:room-compiler:$roomVers")
    implementation("androidx.room:room-ktx:$roomVers")

    // coroutines
    val crVers = "1.7.3" // 1.5.2 in course
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${crVers}")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:${crVers}")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:${crVers}")

    //coroutine lifecycle scopes
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0") //2.4.0 in course

}

