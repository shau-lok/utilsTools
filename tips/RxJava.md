

# RxJava


### Observable

发送消息

可以发送任意数量的消息,当消息被成功处理或者出错时，流程结束

调用它的每个Subscriber的Subscriber.onNext()函数，并最终以Subscriber.onComplete()或者Subscriber.onError()结束。

一般只有等到有Subscriber订阅它，才会开始发送消息

（术语上讲就是热启动Observable和冷启动Observable。热启动Observable任何时候都会发送消息，即使没有任何观察者监听它。冷启动Observable只有在至少有一个订阅者的时候才会发送消息（我的例子中都是只有一个订阅者）

### Subscriber

消费消息


### Example

创建一个基本的Observable：

```java
Observable<String> myObservable = Observable.create(new Observable.OnSubscribe<String>() {
           @Override
           public void call(Subscriber<? super String> subscriber) {
               subscriber.onNext("Hello World");
               subscriber.onCompleted();
           }
       });
```

Observable发送“Hello,world!”消息然后完成。现在让我们创建Subscriber来消费这个数据

```java
Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {
                Debug.log("Subscriber", "on Completed()");
            }

            @Override
            public void onError(Throwable e) {
                Debug.log("Subscriber", "on Error(): " + e.toString());
            }

            @Override
            public void onNext(String s) {
                Debug.log("Subscriber", "on Next(): " + s);
            }
        };
```

关联

```java
myObservable.subscribe(mySubscriber);
```

### map()

将已被发送的消息转换成另外一种形式：

```java
Observable.just("Hello, world!")
    .map(new Func1<String, String>() {
        @Override
        public String call(String s) {
            return s + " -Dan";
        }
    })
    .subscribe(s -> System.out.println(s));
```

它不需要发送和原始的Observable一样的数据类型。假如我的Subscriber不想直接输出原始的字符串，而是想输出原始字符串的hash值：

```java
Observable.just("Hello, world!")
    .map(new Func1<String, Integer>() {
        @Override
        public Integer call(String s) {
            return s.hashCode();
        }
    })
    .subscribe(i -> System.out.println(Integer.toString(i)));
```

任何事情都是可能的。 你的Observable可以是一个数据库查询，Subscriber获得查询结果然后将其显示在屏幕上。

你的Observable可以是屏幕上的一个点击，Subscriber响应该事件。

你的Observable可以从网络上读取一个字节流，Subscriber将其写入本地磁盘中。

我们可以在消息发送者Observable和消息消费者Subscriber之间加入任意多个想要的map()函数
