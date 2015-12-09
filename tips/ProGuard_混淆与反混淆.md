
# ProGuard

优化，缩小，混淆代码

## enable proguard

```java

  android {
   ...
 
    buildTypes {
        release {
            minifyEnabled true

            // Android SDK tools/proguard 目录下
            proguardFiles getDefaultProguardFile('proguard-android.txt'),

            // module根目录下
            'proguard-rules.pro'
        }
    }
  }
```

## 配置 proguard

保持一些代码不变

```java
-keep public class <MyClass>
```


## 线上版本崩溃堆栈逆向还原

在app上线前gradle要经过``assembleRelease``过程

在 /app/build/outputs/ 目录下生成如下几个有用的东西:

- /apk/... ［上线的包]()
- /mapping/flavor/release/mapping.txt [混淆堆栈必备品](https://developer.android.com/tools/help/proguard.html#decoding)

### 还原BEFORE

经过ProGuard混淆过的代码异常堆栈

```java
Caused by: java.lang.NullPointerException
at net.simplyadvanced.ltediscovery.be.u(Unknown Source)
at net.simplyadvanced.ltediscovery.at.v(Unknown Source)
at net.simplyadvanced.ltediscovery.at.d(Unknown Source)
at net.simplyadvanced.ltediscovery.av.onReceive(Unknown Source)
```

### 还原AFTER

```java
Caused by: java.lang.NullPointerException
at net.simplyadvanced.ltediscovery.UtilTelephony.boolean is800MhzNetwork()(Unknown Source)
at net.simplyadvanced.ltediscovery.ServiceDetectLte.void checkAndAlertUserIf800MhzConnected()(Unknown Source)
at net.simplyadvanced.ltediscovery.ServiceDetectLte.void startLocalBroadcastReceiver()(Unknown Source)
at net.simplyadvanced.ltediscovery.ServiceDetectLte$2.void onReceive(android.content.Context,android.content.Intent)(Unknown Source)
```

### 还原方法

```bash
$ cd /Users/shau-lok/Android/sdk/tools/proguard/bin
$ ls
-   proguard.sh  
-   proguardgui.sh 
-   retrace.sh  # tool convert an obfuscated stack trace to a readable one
```

使用 retrace.sh 进行还原

```bash
retrace.sh -verbose mapping.txt [<stacktrace_file>]
```

example

```bash
 ./retrace.sh -verbose  ~/Desktop/outputs/mapping/flavor1/release/mapping.txt
```

粘贴堆栈信息到终端,retrace.sh 就会自动解释还原:)

- <stacktrace_file> 存放异常堆栈信息的文件
- <stacktrace_file> 忽略时，retrace.sh 会在命令行中读取标准输入


> 有必要每次发包的时候都将生成的 ``mapping.txt`` 根据版本号进行存储




