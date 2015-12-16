
# Intent 

激活活动、服务和广播接收器

显式Intent 

- 明确指定了Intent应该传递给哪个组件

隐式Intent 

- 根据隐式意图中设置的动作(action)、类别(category)、数据（URI和数据类型）找到最合适的组件来处理这个意图。

```java
<intent-filter>
<action android:name=”com.example.project.SHOW_CURRENT” />
<action android:name=”com.example.project.SHOW_RECENT” />
<action android:name=”com.example.project.SHOW_PENDING” />
</intent-filter>
```

When you create an implicit intent   

the Android system finds the appropriate component to start by comparing the contents of the intent to the intent filters declared in the ``manifest`` file of other apps on the device.

If the intent matches an ``intent filter``, the system starts that component and delivers it the Intent object

If multiple ``intent filters`` are compatible, the system displays a dialog so the user can pick which app to use.

![implicit intent](https://developer.android.com/images/components/intent-filters@2x.png)

declaring an intent filter for an activity, you make it possible for other apps to directly start your activity with a certain kind of intent.

### Action

A string that specifies the generic action to perform (such as view or pick).

```java

//Action:
//Intent StartActivity()
public static final String ACTION_VIEW = "android.intent.action.VIEW";
public static final String ACTION_SEND = "android.intent.action.SEND";

//自定义Action
//be sure to include your app's package name as a prefix
static final String ACTION_TIMETRAVEL = "com.example.action.TIMETRAVEL";
```

### Category

```java

//CATEGORY_BROWSABLE:
// The target activity allows itself to be started by a web 
// browser to display data referenced by a link such as an image or an e-mail message.
public static final String CATEGORY_BROWSABLE = "android.intent.category.BROWSABLE";


//CATEGORY_LAUNCHER:
// The activity is the initial activity of a task and is listed 
// in the system's application launcher.
public static final String CATEGORY_LAUNCHER = "android.intent.category.LAUNCHER";

```

# 被implict Intent 调用

declare one or more intent filters in your manifest file.

每个<intent-filter>里边包括<acton>,<data>,<category>

here's an activity declaration with an intent filter to receive an ACTION_SEND intent when the data type is text:

```java
<activity android:name="ShareActivity">
    <intent-filter>
        <action android:name="android.intent.action.SEND"/>
        <category android:name="android.intent.category.DEFAULT"/>
        <data android:mimeType="text/plain"/>
    </intent-filter>
</activity>
```

```java
<activity android:name="MainActivity">
    <!-- This activity is the main entry, should appear in app launcher -->
    <intent-filter>
        <action android:name="android.intent.action.MAIN" />
        <category android:name="android.intent.category.LAUNCHER" />
    </intent-filter>
</activity>

<activity android:name="ShareActivity">
    <!-- This activity handles "SEND" actions with text data -->
    <intent-filter>
        <action android:name="android.intent.action.SEND"/>
        <category android:name="android.intent.category.DEFAULT"/>
        <data android:mimeType="text/plain"/>
    </intent-filter>
    <!-- This activity also handles "SEND" and "SEND_MULTIPLE" with media data -->
    <intent-filter>
        <action android:name="android.intent.action.SEND"/>
        <action android:name="android.intent.action.SEND_MULTIPLE"/>
        <category android:name="android.intent.category.DEFAULT"/>
        <data android:mimeType="application/vnd.google.panorama360+jpg"/>
        <data android:mimeType="image/*"/>
        <data android:mimeType="video/*"/>
    </intent-filter>
</activity>
```

> In order to receive implicit intents, you must include the CATEGORY_DEFAULT category in the intent filter. 

# PendingIntent

Major use cases for a pending intent include:

-  ``Notification`` 
-  ``App Widget`` 
- ``AlarmManager`` 

# <data> URI:

```java
<scheme>://<host>:<port>/<path>
```

```java
content://com.example.project:200/folder/subfolder/etc
```





