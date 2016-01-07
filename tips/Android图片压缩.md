
# Android 压缩图片


对byte[]进行压缩

```java
    /**
     * 压缩图片
     *
     * @param data
     * @return
     */
    public static byte[] CompressImageByte(byte[] data) {
        Bitmap bitmap;
        long fileSize = data.length;
        final long fileMaxSize = 2 * 1024 * 1024;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        if (fileSize >= fileMaxSize) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(data, 0, data.length, options);
            int height = options.outHeight;
            int width = options.outWidth;

            double scale = Math.sqrt((float) fileSize / fileMaxSize);
            options.outHeight = (int) (height / scale);
            options.outWidth = (int) (width / scale);
            options.inSampleSize = (int) (scale + 0.5);
            options.inJustDecodeBounds = false;
            bitmap = BitmapFactory.decodeByteArray(data, 0, data.length, options);
        } else {
            bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
        }

        try {
            bitmap.compress(Bitmap.CompressFormat.PNG, 50, outputStream);
            return outputStream.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return data;
        } finally {
            try {
                outputStream.close();
                if (!bitmap.isRecycled()) {
                    bitmap.recycle();
                }
            } catch (Exception e) {
            }
        }
    }
```

对某个目录文件图片进行压缩

```java
   /** 
     * 压缩图片 
     * 
     * @param ImgPath 
     * @return 
     */ 
    public static String getCompressImage(String ImgPath) {
        Bitmap bitmap;
        File outputFile = new File(ImgPath);
        long fileSize = outputFile.length();
        final long fileMaxSize = 30 * 1024;
        if (fileSize >= fileMaxSize) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(ImgPath, options);
            int height = options.outHeight;
            int width = options.outWidth;
 
 
            double scale = Math.sqrt((float) fileSize / fileMaxSize);
            options.outHeight = (int) (height / scale);
            options.outWidth = (int) (width / scale);
            options.inSampleSize = (int) (scale + 0.5);
            options.inJustDecodeBounds = false;
 
 
            bitmap = BitmapFactory.decodeFile(ImgPath);
        } else { 
            bitmap = BitmapFactory.decodeFile(ImgPath);
        } 
        try { 
            outputFile = new File(getOutputMediaFileUri().getPath());
            FileOutputStream fos = new FileOutputStream(outputFile);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 50, fos);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        } 
        if (!bitmap.isRecycled()) {
            bitmap.recycle();
        } 
 
 
        return outputFile.getAbsolutePath();
 
 
    } 
 ```
