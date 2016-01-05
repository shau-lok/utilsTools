
# terminal 签名证书指引

### 使用keytool工具生成 .keystore 文件

```bash
$ keytool -genkey -v -keystore xxxx.keystore -alias xxxxx.keystore -keyalg Rsa -keysize 2048 -validity 10000 -keypass xxxxx -storepass xxxxx
```

### build.gradle

```gradle
signingConfigs {
        debug {
            storeFile file('xxxx.keystore')
            storePassword "xxxxxx"
            keyAlias 'xxx.keystore'
            keyPassword "xxxx"
        }
        release {
            storeFile file('xxx.keystore')
            storePassword "xxxx"
            keyAlias 'xxxxx.keystore'
            keyPassword "xxxxx"
        }
    }
```

### 高德地图申请key

> show you the MD5 fingerprint

```bash 
$ keytool -v -list -alias xxxx.keystore -keystore xxxxx.keystore
```

输入password

```bash
Certificate fingerprints:
	 MD5:  B4:B8:32:9C:30:50:9F:A1:3C:BC:64:D4:15:BE:71:E4
	 SHA1: BB:B7:B1:C5:04:B1:87:8D:9C:F0:8A:87:BA:63:A1:9B:4D:DA:29:8A
	 SHA256: 04:49:D0:CD:CB:53:56:49:38:F0:ED:DA:B7:A0:22:50:DD:B8:50:5E:74:83:5F:E6:0B:B1:E6:08:FD:09:63:C7
	 Signature algorithm name: SHA256withRSA
	 Version: 3
```



