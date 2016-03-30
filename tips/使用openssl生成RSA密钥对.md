
# 使用openssl生成RSA密钥对

### 进入openssl

```
$ openssl
```

### 生成私钥

```bash
OpenSSL> genrsa -out rsa_private_key.pem 1024
# openssl 随机生成一份私钥，加密长度1024 范围(512~2048)
```

生成如下：

```
-----BEGIN RSA PRIVATE KEY-----
MIICXAIBAAKBgQDOXiyX6C+MQiwcDGp1onMqCbd77XDgZWNb7SE8jDMflzsdUOBs
UdRejj2pnvC8Zj4uCPLrzLtDTfrDFPfY5wCEWNkMbGk67qmkHsm7bIuP6zdS3R34
rcrKgV6/NExlfeTWswVZJNVq8iBD0kmt6s/Vxls3AJwieh4VNJ/bPwCSeQIDAQAB
AoGABcWah7Ely016gFpUi++8OtvEtwGgG5aaXdLXECN3tpV7QMmnTUBIqVBfJyRb
5VkSuiTj7nZucmZ28gffGsDzQbOCu0RUeo2zrhDfdDm+6zMtquQ8vE3fS+PBpFJ5
df7/B4r6JMOG4016lmWFcJ+oWTNa3TFME0hcEUV1KI+6WxECQQDom3RWHxSJnAKK
S28oDCTFSnDkQu/TKelburUMfgnXP3qpfpmEA4LHA4DOhmvMdWogxEKPDxPPu5vG
Lgt0tupVAkEA4x8ty77saO5hHmgT9LsPy7jrM/wPDczn+6sDBDj+bscVFo8GV9NT
y+DdQYQcZXHnSfZoM102RM06OyDx4i5zlQJAHPKbu8wKZkXAGy3gG3/HY7Yr7nxW
FFV28S9/MJrO5rbDsSxMNp2pPNM2yHz6FWvXVVSXY+5gbM3QSQ2Z52CMMQJACZtE
AJ4uubF7giG81lkjLebAbA55RIgqN8bf9cnDWUQqbC3YgtZ5cOIt+Ztw6AmNUt+N
QL7skLRthhq6oGp+kQJBAIrtD8gsjEKpjQJBue+ePilG/rgg7Wir7w6dIqXuFqvf
/H9zwerlSpnRWw87nj3m5IANJuaYmTSmIa2GqevrzeE=
-----END RSA PRIVATE KEY-----
```

### 通过私钥生成公钥

```bash
OpenSSL> rsa -in rsa_private_key.pem -out rsa_public_key.pem -pubout
```

生成如下:

```
-----BEGIN PUBLIC KEY-----
MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDOXiyX6C+MQiwcDGp1onMqCbd7
7XDgZWNb7SE8jDMflzsdUOBsUdRejj2pnvC8Zj4uCPLrzLtDTfrDFPfY5wCEWNkM
bGk67qmkHsm7bIuP6zdS3R34rcrKgV6/NExlfeTWswVZJNVq8iBD0kmt6s/Vxls3
AJwieh4VNJ/bPwCSeQIDAQAB
-----END PUBLIC KEY-----
```

### pkcs#8编码私钥

```
OpenSSL> pkcs8 -topk8 -in rsa_private_key.pem -out pkcs8_rsa_private_key.pem -nocrypt
```

生成如下：

```
-----BEGIN PRIVATE KEY-----
MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAM5eLJfoL4xCLBwM
anWicyoJt3vtcOBlY1vtITyMMx+XOx1Q4GxR1F6OPame8LxmPi4I8uvMu0NN+sMU
99jnAIRY2QxsaTruqaQeybtsi4/rN1LdHfitysqBXr80TGV95NazBVkk1WryIEPS
Sa3qz9XGWzcAnCJ6HhU0n9s/AJJ5AgMBAAECgYAFxZqHsSXLTXqAWlSL77w628S3
AaAblppd0tcQI3e2lXtAyadNQEipUF8nJFvlWRK6JOPudm5yZnbyB98awPNBs4K7
RFR6jbOuEN90Ob7rMy2q5Dy8Td9L48GkUnl1/v8Hivokw4bjTXqWZYVwn6hZM1rd
MUwTSFwRRXUoj7pbEQJBAOibdFYfFImcAopLbygMJMVKcORC79Mp6Vu6tQx+Cdc/
eql+mYQDgscDgM6Ga8x1aiDEQo8PE8+7m8YuC3S26lUCQQDjHy3Lvuxo7mEeaBP0
uw/LuOsz/A8NzOf7qwMEOP5uxxUWjwZX01PL4N1BhBxlcedJ9mgzXTZEzTo7IPHi
LnOVAkAc8pu7zApmRcAbLeAbf8djtivufFYUVXbxL38wms7mtsOxLEw2nak80zbI
fPoVa9dVVJdj7mBszdBJDZnnYIwxAkAJm0QAni65sXuCIbzWWSMt5sBsDnlEiCo3
xt/1ycNZRCpsLdiC1nlw4i35m3DoCY1S341AvuyQtG2GGrqgan6RAkEAiu0PyCyM
QqmNAkG5754+KUb+uCDtaKvvDp0ipe4Wq9/8f3PB6uVKmdFbDzuePebkgA0m5piZ
NKYhrYap6+vN4Q==
-----END PRIVATE KEY-----
```
