

# ipad vpn翻墙事

> 新入手了台二手ipad，国行充新，质量不错

vps 搭载 OpenConnect server

### 下载

```
wget ftp://ftp.infradead.org/pub/ocserv/ocserv-0.9.2.tar.xz
tar -xf ocserv-0.9.2.tar.xz
cd ocserv-0.9.2
```

### 安装依赖

```
apt-get install build-essential pkg-config libgnutls28-dev libwrap0-dev libpam0g-dev libseccomp-dev libreadline-dev libnl-route-3-dev
```

### 编译

查看README.md，看看环境需要啥玩意

```bash
./configure
#各种configure失败，逐个逐个查缺失啥，再装啥呗
make
make install
```

### 配置环境

```bash
apt-get install gnutls-bin
mkdir certificates
cd certificates
```

创建 CA 模板 (***ca.tmpl***) , "cn" & "organization"随便填

```bash
vi ca.tmpl
#加入以下内容

cn = "VPN CA"
organization = "Big Corp"
serial = 1
expiration_days = 3650
ca
signing_key
cert_signing_key
crl_signing_key

```

生成CA key 和证书

```bash
certtool --generate-privkey --outfile ca-key.pem
certtool --generate-self-signed --load-privkey ca-key.pem --template ca.tmpl --outfile ca-cert.pem
```

创建服务端证书模板(***server.tmpl***) "cn" 写服务器ip地址

```bash
vi server.tmpl
#加入以下内容

cn = "you domain name or ip"
organization = "MyCompany"
expiration_days = 3650
signing_key
encryption_key
tls_www_server

```

生成server key 和证书

```bash
certtool --generate-privkey --outfile server-key.pem
certtool --generate-certificate --load-privkey server-key.pem --load-ca-certificate ca-cert.pem --load-ca-privkey ca-key.pem --template server.tmpl --outfile server-cert.pem
```

复制证书到 /etc/ocserv

```bash
mkdir /etc/ocserv
cp server-cert.pem server-key.pem /etc/ocserv
cd ~/ocserv-0.9.2/doc
cp sample.config /etc/ocserv/config
cd /etc/ocserv
```

Edit config file

```bash
vi /etc/ocserv/config

#修改以下数据:

auth = "plain[/etc/ocserv/ocpasswd]"

try-mtu-discovery = true

server-cert = /etc/ocserv/server-cert.pem
server-key = /etc/ocserv/server-key.pem

dns = 8.8.8.8

# comment out all route fields
#route = 10.10.10.0/255.255.255.0
#route = 192.168.0.0/255.255.0.0
#route = fef4:db8:1000:1001::/64
#no-route = 192.168.5.0/255.255.255.0

cisco-client-compat = true

```

生成用户名，并且输入密码

```bash
ocpasswd -c /etc/ocserv/ocpasswd sailear
```

Enable NAT

```bash
iptables -t nat -A POSTROUTING -j MASQUERADE
```

Enable IPv4  Edit the file ***/etc/sysctl.conf***.

```bash
net.ipv4.ip_forward=1
```

应用 ***/etc/sysctl.conf***

```bash
sysctl -p /etc/sysctl.conf
```

### 开服务

```bash
ocserv -c /etc/ocserv/config
```

## 注意:

- 同一个vps搭载shadowsocks and OpenConnect Vpn server,有可能同时会同时占用到443端口,导致开启 OpenConnect 服务器启动不了，此时需要将shadowsocks监听端口改成别的，``cisco anyconnect客户端必须要服务端VPN监听443端口``

- ipad 使用 anyconnect 配置

  - 连接输入vps ip地址
  - 设置将阻止不信任的服务器关掉
  - AnyConnect VPN 打开，依次输入账号密码

- 如果有其他服务占用了443端口，kill死那个服务

```bash
#查看程序端口占用情况
netstat –apn | grep 443
```

### website:

- [ios配置cisco-anyconnect教程](https://www.joyvm.com/tutorials/ios-anyconnect-setup)

- [server搭载教程](https://www.vultr.com/docs/setup-openconnect-vpn-server-for-cisco-anyconnect-on-ubuntu-14-04-x64)



----

## 通过证书验证

进入certificates目录创建user.tmpl

```
cn = "some random name"
unit = "some random unit"
expiration_days = 365
signing_key
tls_www_client
```

创建user密钥

```
certtool --generate-privkey --outfile user-key.pem
```

User证书

```
certtool --generate-certificate --load-privkey user-key.pem --load-ca-certificate ca-cert.pem --load-ca-privkey ca-key.pem --template user.tmpl --outfile user-cert.pem
```

然后要将证书和密钥转为PKCS12的格式

```
certtool --to-p12 --load-privkey user-key.pem --pkcs-cipher 3des-pkcs12 --load-certificate user-cert.pem --outfile user.p12 --outder
```

user.p12即可导入到手机

关于OCserv的配置

```
# 改为证书登陆，注释掉原来的登陆模式
auth = "certificate"

# 证书认证不支持这个选项，注释掉这行
#listen-clear-file = /var/run/ocserv-conn.socket

# 启用证书验证
ca-cert = /etc/ssl/private/my-ca-cert.pem
```


关于端口转发

```
iptables -t nat -A POSTROUTING -j MASQUERADE
iptables -A FORWARD -p tcp --tcp-flags SYN,RST SYN -j TCPMSS --clamp-mss-to-pmtu
```

