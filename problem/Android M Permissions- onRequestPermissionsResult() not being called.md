
# Android 6.0 运行时请求权限

> onRequestPermissionsResult() not being called

解决方案:

- in AppCompatActivity, should use ***ActivityCompat.requestPermissions;***

- When in android.support.v4.app.Fragment, should use simply requestPermissions

如果在fragment中使用 ***AppCompatActivity.requestPermissions*** , onRequestPermissionsResult会失效


---


请求权限方法:

AppCompatActivity中

```java

ActivityCompat.requestPermissions(thisActivity,
              new String[]{Manifest.permission.READ_CONTACTS},
              MY_PERMISSIONS_REQUEST_READ_CONTACTS);
```

处理请求返回码

```java

@Override
public void onRequestPermissionsResult(int requestCode,
        String permissions[], int[] grantResults) {
    switch (requestCode) {
        case MY_PERMISSIONS_REQUEST_READ_CONTACTS: {
            // If request is cancelled, the result arrays are empty.
            if (grantResults.length > 0
                && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                // permission was granted, yay! Do the
                // contacts-related task you need to do.

            } else {

                // permission denied, boo! Disable the
                // functionality that depends on this permission.
            }
            return;
        }

        // other 'case' lines to check for other
        // permissions this app might request
    }
}

```
