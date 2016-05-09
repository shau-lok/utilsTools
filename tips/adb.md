
# adb

### Server 死机情况

```bash
$ adb kill-server
```

```bash
$ adb start-server
```

### List of devices attached

```bash
$ adb devices
```

### logcat

```bash
$ adb logcat
```

### find something.

```bash
$ find / -name "*mmssms*”
```

### take a device screenshot.

```bash
$ adb shell screencap /sdcard/screen.png
```

```bash
$ adb pull /sdcard/screen.png
```

```bash
$ adb push screen.png /sdcard/screen.png
```
