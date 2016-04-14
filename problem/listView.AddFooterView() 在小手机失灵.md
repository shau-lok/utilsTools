# listView.AddFooterView() 在小手机失灵

## Problem fixed from stackOverFlow 

[I am using the listview add/remove footer for listview cross app in android version 4.3?](https://stackoverflow.com/questions/16622515/android-studio-dont-generate-r-java-for-my-import-project)

### Problem:

- Android 4.4 以上 ListView 正常显示AddFooterView()内容
- Android 4.3 以下 ListView 反而显示不出AddFooterView内容

### Why:

probably caused by calling setAdapter() before addFooterView()

在 API 15 AddFooterView()源码的注释如下：

```
/*
 * NOTE: Call this before calling setAdapter. This is so ListView can wrap
 * the supplied cursor with one that will also account for header and footer
 * views.
 */
```

在 KitKat放松了这个限制，代码注释如下：

```
/*
 * Note: When first introduced, this method could only be called before
 * setting the adapter with {@link #setAdapter(ListAdapter)}. Starting with
 * {@link android.os.Build.VERSION_CODES#KITKAT}, this method may be
 * called at any time.
```

### Fixed:

如果需要在 API 18 以下正常显示：

必须先调***AddFooterView()***,然后***SetAdapter()***

