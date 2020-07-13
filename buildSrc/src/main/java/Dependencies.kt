object Dependencies {

    object Android {
        const val gradle = "com.android.tools.build:gradle:4.0.0"
        const val appCompat = "androidx.appcompat:appcompat:1.3.0-alpha01"
        const val core = "androidx.core:core-ktx:1.5.0-alpha01"
    }

    object Lifecycle {
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
        const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
        const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
        const val compiler = "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycle}"
    }

    object Kotlin {
        const val coroutinesBom = "org.jetbrains.kotlinx:kotlinx-coroutines-bom:1.3.7"
        const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core"
        const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android"
        const val coroutinesRx2 = "org.jetbrains.kotlinx:kotlinx-coroutines-rx2"
    }

    object SquareUp {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val gsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
        const val okhttpInterceptor = "com.squareup.okhttp3:logging-interceptor:4.7.2"
    }

    object ReactiveX {
        const val java = "io.reactivex.rxjava2:rxjava:2.2.19"
        const val android = "io.reactivex.rxjava2:rxandroid:2.1.1"
    }
}