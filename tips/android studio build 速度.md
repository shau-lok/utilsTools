
＃ android studio build项目速度


### build.gradle 依赖犯错

1. 

```java
dependencies {

//	 compile 'com.android.support:appcompat-v7:22.+' 
 	//需要具体到版本号，不然android studio不知道选哪个，导致build时狗屎漫长等待


    //正确写法
	compile 'com.android.support:appcompat-v7:22.2.1'
}
```

2. 

> 说不定gfw又搞鬼

依赖包的导入也是有可能被gfw墙掉，也会导致build时狗屎慢

***解决方案***

- google 单独下载需要导入的jar包
- 在 projectName/app/ 下创建 libs 文件夹，放入下好的jar包
- add as library


