import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget
import org.jetbrains.kotlin.konan.target.Family

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.serialization)
}

kotlin {
    androidTarget {
        compilations.all {
            compileTaskProvider.configure {
                compilerOptions {
                    jvmTarget.set(JvmTarget.JVM_1_8)
                }
            }
        }
    }

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    targets
        .filterIsInstance<KotlinNativeTarget>()
        .filter { it.konanTarget.family == Family.IOS }
        .forEach { target ->
            target.binaries {
                framework {
                    baseName = "shared"
                    isStatic = true

                    export(libs.decompose)
                    export(libs.decompose.extensions)
                    export(libs.essenty.lifecycle)
                }
            }
        }

    sourceSets {
        commonMain.dependencies {
            api(libs.decompose)
            api(libs.decompose.extensions)
            api(libs.essenty.lifecycle)
        }

        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }

        iosMain {
            dependencies {

            }
        }
    }
}

android {
    namespace = "com.tishukoff.decomposewithmvikotlin"
    compileSdk = 34
    defaultConfig {
        minSdk = 26
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}
