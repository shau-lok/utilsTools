
# 解决Android Base64编码转义字符

> Base64编码时，出现**\n**等转义字符,导致字符串出问题

```java
import	android.util.Base64;
```

### Encode:

```java
//flag 使用 Base64.NO_WRAP | Base64.URL_SAFE
Base64.encodeToString(cipher, Base64.NO_WRAP | Base64.URL_SAFE);
```

### Decode:

```java
byte[] ciphers = Base64.decode(cipher, Base64.NO_WRAP | Base64.URL_SAFE);
```

### FLAGS:

1. DEFAULT  (默认方法)
2. NO_PADDING (删除最后的"=")
3. NO_WRAP (删除所有换行符号)
4. URL_SAFE (不使用有特殊意义的字符，使用"-"代替"+"，使用"_"代替"/")


### Website:

[Android developer](https://developer.android.com/reference/android/util/Base64.html)
