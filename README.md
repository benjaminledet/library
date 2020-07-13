# Library

Description

# Installation

Library requires at minimum Android API 21+.

In your project build.gradle file :
``` 
allprojects {
    repositories {
        maven {
            url = uri("https://maven.pkg.github.com/benjaminledet/library")
            credentials {
                username = "..."
                password = "..."
            }
        }
    }
}
```

In your application build.gradle file :
```
dependencies {
    implementation 'benjamin.ledet:core:(insert latest version)'
    
    // optional - Add this if you don't want to use kotlin coroutines
    implementation 'benjamin.ledet:kotlin-callbacks:(insert latest version)'
    
    // optional - Add this for java support
    implementation 'benjamin.ledet:java:(insert latest version)'
    
    // optional - Add this for java and rx2 support
    implementation 'benjamin.ledet:java-rx2:(insert latest version)'
}
```
