
import com.android.build.gradle.AppExtension
import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.LibraryPlugin

buildscript {

    repositories {
        google()
        jcenter()
        mavenCentral()
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
    }

    dependencies {
        classpath(kotlin("gradle-plugin", Versions.kotlin))
        classpath(Dependencies.Android.gradle)
        classpath("org.jetbrains.dokka:dokka-gradle-plugin:0.10.1")
        classpath("co.uzzu.dotenv:gradle:1.1.0")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        maven(url = "https://jitpack.io")
    }
}

subprojects {
    // Accessing the `PluginContainer` in order to use `whenPluginAdded` function
    project.plugins.configure(project = project)
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

// Extension function on `PluginContainer`
fun PluginContainer.configure(project: Project) {
    whenPluginAdded {
        when (this) {
            is LibraryPlugin -> {
                project.extensions
                    .getByType<LibraryExtension>()
                    .apply {
                        applyCommons()
                    }
            }
            is com.android.build.gradle.DynamicFeaturePlugin -> {
                project.extensions
                    .getByType<AppExtension>()
                    .apply {
                        applyCommons()
                    }
            }
        }
    }
}

// Extension function on `AppExtension`
fun AppExtension.applyCommons() {
    compileSdkVersion(Versions.compile)

    defaultConfig.apply {
        minSdkVersion(Versions.minimum)
        targetSdkVersion(Versions.target)
        versionCode = Versions.versionCode
        versionName = Versions.versionName
        consumerProguardFile("proguard-rules.pro")
    }

    compileOptions.apply {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

// Extension function on `LibraryExtension`
fun LibraryExtension.applyCommons() {
    compileSdkVersion(Versions.compile)

    defaultConfig.apply {
        minSdkVersion(Versions.minimum)
        targetSdkVersion(Versions.target)
        versionCode = Versions.versionCode
        versionName = Versions.versionName
        consumerProguardFile("proguard-rules.pro")
    }

    compileOptions.apply {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}