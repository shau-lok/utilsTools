
#  EGL_BAD_ALLOC on Android 2.3.x


> android2.3.6  GT-I9108

LOG_CONTENT:

```java
java.lang.RuntimeException: eglMakeCurrent failed: EGL_BAD_ALLOC
at android.opengl.GLSurfaceView$EglHelper.throwEglException(GLSurfaceView.java:1099)
at android.opengl.GLSurfaceView$EglHelper.throwEglException(GLSurfaceView.java:1091)
at android.opengl.GLSurfaceView$EglHelper.createSurface(GLSurfaceView.java:1011)
at android.opengl.GLSurfaceView$GLThread.guardedRun(GLSurfaceView.java:1355)
at android.opengl.GLSurfaceView$GLThread.run(GLSurfaceView.java:1138)
```

Starting application several times(20-30 times) after pause or dispose.  

- memory use will increase(Cache)
- if memory use is about 50 MB it will crash






