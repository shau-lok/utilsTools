
# sdkman的一些事

> 俺的电脑装了好几个version的gradle ，然后想知道gradle 安装在哪个位置，iTerm则click一下link,就找到找到了耶..

### sdkman安装的路径

```
~/Users/shau-lok/.sdkman/candidates/gradle/
```

```bash
➜  2.2 pwd
/Users/shau-lok/.sdkman/candidates/gradle/2.2
➜  2.2 cd ..
➜  gradle ls
2.14.1  2.2     3.0     current
```

### 俺想自由切换 bash 用哪个gradle版本 的话

```bash
# Use Version (仅限本次打开的终端会使用)
$ sdk use gradle 2.2

# Default Version (默认的版本)
$ sdk default gradle 3.0

# Current Version (当前版本用了啥)
$ sdk current gradle
```

### 俺想知道sdk帮我装了啥

```bash
$ sdk list
```

