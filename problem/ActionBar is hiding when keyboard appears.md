


#  ActionBar is hiding when keyboard appears

> 使用EditText出现keyboard上，ActionBar消失

解决方案：

- AndroidManifest.xml 中Activity加上***android:windowSoftInputMode="stateUnchanged|adjustResize”***

```xml
<activity
            android:name=".view.ComposeActivity"
            android:configChanges="orientation|keyboardHidden|navigation"
            android:screenOrientation="portrait"
            android:label="发送消息"
            android:launchMode="singleTask"
            android:theme="@style/AppTheme.NoActionBar"
            android:windowSoftInputMode="stateUnchanged|adjustResize">

        </activity>
```
