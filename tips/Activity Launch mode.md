
# LaunchMode

### android:taskAffinity

- 描述了不同Activity之前的亲密关系。
- 相同的taskAffinity的Activity是亲密的，之间相互跳转，会位于同一个task中

### standard模式

- Activity可以拥有多个实例，而且这些实例既可以位于同一个task或者不同task

### singleTop模式

- 同一个task中，如果存在该activity实例，把该实例丢到栈顶，不需要创建

### singleTask模式

- 如果第一次创建该Activity实例，则会新建task并将activity丢到该task中，否则打开已有的Activity实例
- 只容许有一个包含该Activity实例的task存在
- 与android:taskAffinity相关

### singleInstance模式

- 任意时刻，最多只允许存在一个实例
- 不受taskAffinity影响