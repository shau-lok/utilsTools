
# Okhttp3 的一些文档

### [官方文档](https://github.com/square/okhttp/wiki/Recipes)

---

### OkhttpClient

```java
  OkHttpClient client;
  client = new OkHttpClient.Builder()
                    .proxy(xxx)
                    .hostnameVerifier(xxxx)
                    .sslSocketFactory(xxxx)
                    .connectTimeout(CONNECTION_TIMEOUT_MS, TimeUnit.MILLISECONDS)
                    .readTimeout(READ_TIMEOUT_MS, TimeUnit.MILLISECONDS)
                    .build();
```

### Request

```java
   Request.Builder requestBuilder;
   requestBuilder = new Request.Builder()
                    .url(mURL)
                    .header("Accept-Encoding", "gzip")
                    .addHeader("User-Agent","I LOVE INNMALL");
```

### RequsetBody

```java
	public static final MediaType MEDIA_TYPE_MARKDOWN
    	  = MediaType.parse("text/x-markdown; charset=utf-8");
    File file = new File("README.md");

    Request request = new Request.Builder()
        .url("https://api.github.com/markdown/raw")
        .post(RequestBody.create(MEDIA_TYPE_MARKDOWN, file))
        .build();
```

### Response 

```java
 response = client.newCall(requestBuilder.build()).execute();

 String responseCode = Response.code();      // code=200,400,500
 ResponseBody Content  = Response.body();    // 返回内容

```

### Post Form parameters (post form 参数)

```java
  private final OkHttpClient client = new OkHttpClient();

  public void run() throws Exception {
    RequestBody formBody = new FormBody.Builder()
        .add("search", "Jurassic Park")
        .build();
    Request request = new Request.Builder()
        .url("https://en.wikipedia.org/w/index.php")
        .post(formBody)
        .build();

    Response response = client.newCall(request).execute();
    if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

    System.out.println(response.body().string());
  }
 ```

