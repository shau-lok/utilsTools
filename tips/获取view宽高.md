
# 获取view的宽高

### 问题:

在Activity中获取view的高度，onCreate执行完了，控件才会开始被测量高度.

导致了view.getHeight()为0

### 解决方案:

```java
public int getViewWidth(View view){
  view.measure(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
  return view.getMeasureWidth();
}

public int getViewHeight(View view){
  view.measure(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
  // or View.measure(LayoutParams.WRAP_CONTENT,View.MeasureSpec.makeMeasureSpec(0,View.measureSpec.UNSPECIFIED));
  return view.getMeasureHeight();
}

```

***OR: ***

```java
// 监听ViewTreeObserver.onGlobalLayoutListener
int mHeaderViewHeight;
mHeaderView.getViewTreeObserver().addOnGlobalLayoutListener(
        new onGlobalLayoutListener(){
          @override
          public void onGlobalLayout(){
              mHeaderViewHeight = mHeaderView.getHeight();
              getViewTreeObserver()
                    .removeGlobalOnLayoutListener(this);
          }
        }
);
```

***OR: ***

```java
//onResume调用view.getWidth获取宽
```
