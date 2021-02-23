@file:Suppress("unused", "SpellCheckingInspection")

package com.documentary.buildsrc

object Versions {
    const val ktlint = "0.39.0"
}

object Libs {

    const val androidGradlePlugin = "com.android.tools.build:gradle:4.1.1"

    const val MPAAndroidCharts = "com.github.PhilJay:MPAndroidChart:v3.1.0"
    const val timber = "com.jakewharton.timber:timber:4.7.1"
    const val easypermissions = "pub.devrel:easypermissions:3.0.0"
    const val materialDesign = "com.google.android.material:material:1.1.0"

    const val junit = "junit:junit:4.13"
    const val robolectric = "org.robolectric:robolectric:4.4"
    const val store = "com.dropbox.mobile.store:store4:4.0.0-beta01"

    /**********************************************************************************************/

    object Kotlin {
        private const val version = "1.4.10"
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$version"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
        const val extensions = "org.jetbrains.kotlin:kotlin-android-extensions:$version"
    }

    /**********************************************************************************************/

    object Coroutines {
        private const val version = "1.4.2"
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
        const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
    }

    /**********************************************************************************************/

    object Insetter {
        private const val version = "0.3.1"
        const val dbx = "dev.chrisbanes:insetter-dbx:$version"
        const val ktx = "dev.chrisbanes:insetter-ktx:$version"
    }

    /**********************************************************************************************/

    object Glide {
        private const val version = "4.11.0"
        const val glide = "com.github.bumptech.glide:glide:$version"
        const val compiler = "com.github.bumptech.glide:compiler:$version"
    }

    /**********************************************************************************************/

    object GooglePlay {
        const val location = "com.google.android.gms:play-services-location:17.1.0"
        const val maps = "com.google.android.gms:play-services-maps:17.0.0"
    }

    /**********************************************************************************************/

    object AndroidX {
        const val appcompat = "androidx.appcompat:appcompat:1.2.0"
        const val constraintlayout = "androidx.constraintlayout:constraintlayout:2.0.4"
        const val coreKtx = "androidx.core:core-ktx:1.3.2"
        const val swiperefresh = "androidx.swiperefreshlayout:swiperefreshlayout:1.1.0"


        // Preferences DataStore
        const val datastore = "androidx.datastore:datastore-preferences:1.0.0-alpha04"

        /**********************************************************************************************/

        object Test {
            private const val version = "1.3.0"
            const val core = "androidx.test:core:$version"
            const val rules = "androidx.test:rules:$version"

            object Ext {
                private const val version = "1.1.2"
                const val junit = "androidx.test.ext:junit-ktx:$version"
            }

            const val espressoCore = "androidx.test.espresso:espresso-core:3.3.0"

            const val archCoreTesting = "androidx.arch.core:core-testing:2.1.0"

            const val MOCKK = "io.mockk:mockk:1.10.2"
            const val ASSERTJ = "org.assertj:assertj-core:3.17.2"
            const val RUNNER = "androidx.test:runner:${version}"

            const val COROUTINES_TEST = "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.3.9"
            const val FRAGMENT_TEST = "androidx.fragment:fragment-testing:1.2.5"
            const val MOCK_WEB_SERVER = "com.squareup.okhttp3:mockwebserver:4.9.0"
        }


        /**********************************************************************************************/

        object Lifecycle {
            private const val version = "2.2.0"
            const val extensions = "androidx.lifecycle:lifecycle-extensions:$version"
            const val livedata = "androidx.lifecycle:lifecycle-livedata-ktx:$version"
            const val viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
        }

        /**********************************************************************************************/

        object Navigation {
            private const val version = "2.3.0"
            const val fragment = "androidx.navigation:navigation-fragment-ktx:$version"
            const val ui = "androidx.navigation:navigation-ui-ktx:$version"
            const val safeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:$version"
        }

        /**********************************************************************************************/

        object Fragment {
            private const val version = "1.3.0-beta01"
            const val fragment = "androidx.fragment:fragment:$version"
            const val fragmentKtx = "androidx.fragment:fragment-ktx:$version"
        }

        /**********************************************************************************************/

        object Room {
            private const val version = "2.3.0-alpha02"
            const val common = "androidx.room:room-common:$version"
            const val runtime = "androidx.room:room-runtime:$version"
            const val compiler = "androidx.room:room-compiler:$version"
            const val ktx = "androidx.room:room-ktx:$version"
            const val testing = "androidx.room:room-testing:$version"
        }

        /**********************************************************************************************/

        object Hilt {
            private const val version = "1.0.0-alpha02"
            const val viewmodel = "androidx.hilt:hilt-lifecycle-viewmodel:$version"
            const val compiler = "androidx.hilt:hilt-compiler:$version"
        }
    }

    /**********************************************************************************************/

    object Dagger {
        private const val version = "2.29.1"
        const val dagger = "com.google.dagger:dagger:$version"
        const val compiler = "com.google.dagger:dagger-compiler:$version"
    }

    /**********************************************************************************************/

    object Hilt {
        private const val version = "2.29.1-alpha"
        const val library = "com.google.dagger:hilt-android:$version"
        const val compiler = "com.google.dagger:hilt-android-compiler:$version"
        const val testing = "com.google.dagger:hilt-android-testing:$version"
        const val gradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:$version"
    }

    /**********************************************************************************************/

    object Retrofit {
        private const val version = "2.9.0"
        const val retrofit = "com.squareup.retrofit2:retrofit:$version"
        const val gsonConverter = "com.squareup.retrofit2:converter-gson:$version"
    }

    /**********************************************************************************************/

    object OkHttp {
        private const val version = "4.9.0"
        const val okhttp = "com.squareup.okhttp3:okhttp:$version"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:$version"
    }

    /**********************************************************************************************/

    object imageCustom {
        private const val version = "3.1.0"
        const val circleimageview = "de.hdodenhof:circleimageview:$version"
    }

    object Paging {
        private const val version = "3.0.0-alpha09"
        const val paging3 = "androidx.paging:paging-runtime-ktx:$version"

    }


}