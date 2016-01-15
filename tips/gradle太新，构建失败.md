
 #   Plugin is too old, please update to a more recent version, or set ANDROID_DAILY_OVERRIDE environment variable to xxxxx

/app/build.gradle

```java
apply plugin: 'com.android.application'

android {
    compileSdkVersion 22
    buildToolsVersion "22.0.1"

    defaultConfig {
        applicationId "com.shootloking.secretmessager"
        minSdkVersion 21
        targetSdkVersion 22
        versionCode 1
        versionName "1.0"
    }
    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
    }
}

dependencies {
    compile fileTree(dir: 'libs', include: ['*.jar'])
    testCompile 'junit:junit:4.12'
    compile 'com.android.support:appcompat-v7:22.2.0'
    compile 'com.android.support:support-v4:22.2.0'
    compile 'com.android.support:design:22.2.0'
}
```

top build.gradle

```java

// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        jcenter()
    }
    dependencies {
    	classpath 'com.android.tools.build:gradle:2.0.0-alpha2'

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        jcenter()
    }
}

task clean(type: Delete) {
    delete rootProject.buildDir
}

```

### 解决方案

change:

```java
// classpath 'com.android.tools.build:gradle:2.0.0-alpha2'
```

to:

```java 
classpath 'com.android.tools.build:gradle:1.5.0'
```

> 主要由于gradle太新了，然而狗屎下不了android support library 23+ ,只好用 22+


