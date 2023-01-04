plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("maven-publish")
}

android {
    namespace = "com.wonddak.switchview"
    compileSdk = 33

    defaultConfig {
        minSdk = 21
        targetSdk = 31

        vectorDrawables {
            useSupportLibrary = true
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
        kotlinCompilerExtensionVersion = "1.3.2"
    }
    packagingOptions {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}

dependencies {
    val composeUiVersion = "1.1.1"
    implementation("androidx.compose.material:material:1.3.1")

    implementation("androidx.compose.ui:ui:$composeUiVersion")
    implementation("androidx.compose.ui:ui-tooling-preview:$composeUiVersion")

    androidTestImplementation("androidx.compose.ui:ui-test-junit4:$composeUiVersion")
    debugImplementation("androidx.compose.ui:ui-tooling:$composeUiVersion")
    debugImplementation("androidx.compose.ui:ui-test-manifest:$composeUiVersion")
}

afterEvaluate {
    val group = "com.github.jmseb3"
    val artifact = "switchView"
    val libVersion = "1.0.0"

    publishing {
        publications {
            create<MavenPublication>("release") {
                groupId = group
                artifactId = artifact
                version = libVersion

                from(components["release"])
            }
        }
    }
}