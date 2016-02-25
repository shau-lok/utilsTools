


# SMS 发送信息 intent 指定特定的app

> 有时候由于手机上的同时存在几个短信app，intent启动后会出现，share chooser

禁止Intent.createChooser 并且启动特定的app

```java
Intent intent = new Intent(Intent.ACTION_SEND);
       if (contact.getmNumber() == null) {
           intent.setData(Uri.parse("sms:"));
       } else {
           intent.setData(Uri.parse("smsto:" + contact.getmNumber()));
       }

       String defaultSmsPackageName = Telephony.Sms.getDefaultSmsPackage(this);
       if (!TextUtils.isEmpty(defaultSmsPackageName)) {
           intent.setPackage(defaultSmsPackageName);
       }

       intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
       intent.putExtra(Intent.EXTRA_TEXT, body);
       intent.putExtra("sms_body", body);
       intent.putExtra("AUTOSEND", "1");
       context.startActivity(intent);

```

关键在于

```java
String defaultSmsPackageName = Telephony.Sms.getDefaultSmsPackage(this);
if (!TextUtils.isEmpty(defaultSmsPackageName)) {
    intent.setPackage(defaultSmsPackageName);
}
```
