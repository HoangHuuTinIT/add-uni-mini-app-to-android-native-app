plugins {
    alias(libs.plugins.android.application)
}
val mfph = mapOf(
    "apk.applicationId" to "com.example.my_java_kotlindsl_uniappx_app"
)
android {
    namespace = "com.example.my_java_kotlindsl_uniappx_app"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.my_java_kotlindsl_uniappx_app"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        ndk {
            // Hỗ trợ các kiến trúc CPU này
            abiFilters += listOf("x86", "armeabi-v7a", "arm64-v8a")
        }
        manifestPlaceholders.putAll(mfph)
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

    }
    aaptOptions {
        additionalParameters += listOf("--auto-add-overlay")
        ignoreAssetsPattern = "!.svn:!.git:.*:!CVS:!thumbs.db:!picasa.ini:!*.scc:*~"
    }
    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard.cfg"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation(fileTree("libs") { include("*.jar") })
    implementation(fileTree("libs") { include("*.aar") })
    implementation ("androidx.recyclerview:recyclerview:1.0.0")
    implementation ("androidx.legacy:legacy-support-v4:1.0.0")
    implementation ("androidx.appcompat:appcompat:1.0.0")
    implementation ("com.alibaba:fastjson:1.2.83")
    implementation ("com.facebook.fresco:fresco:2.5.0")
    implementation ("com.facebook.fresco:animated-gif:2.5.0")
    implementation ("com.github.bumptech.glide:glide:4.9.0")
    implementation ("androidx.webkit:webkit:1.5.0")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.9.0")
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}