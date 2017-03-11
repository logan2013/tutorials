https://dzone.com/articles/the-truth-of-java-exceptions-whats-really-going-on

http://blog.takipi.com/the-surprising-truth-of-java-exceptions-what-is-really-going-on-under-the-hood/

异常的底层分析


1. 栈-线程独立
包含frames，实时导向程序当前运行点。当一个方法终止的时候（正常return或是有uncaught的异常抛出时），frame会从栈里弹出

2. Non-Heap内存-线程共享

指所有在Heap之外分配的内存，其中就包含了exception table

Java8以后，PerGem被替换为Metaspace，它们的作用是一样的，只是实现不同。其中最突出的是，Java 8之后就不需要指定PermGen的大小，因为Metaspace在运行时会动态调整大小

3. Exception table保存在PermGen/Metaspace中，每个方法存在一份。当一个方法定义了try-catch或者finally语句，Exception table会被创建

当异常抛出时，JVM会使用exception table来定位handler。如果handler不存在，stack frame回被弹出，同时异常回被rethrown到根据stack trace找到的calling方法

4. Uncaught异常的恐怖故事
如果没有任何地方catch异常会发生什么呢？stack frame会一个接一个地被弹出，直到到达trace中最后一个方法（单线程环境下是main方法）。如果同样没有handler，thread就会死掉。如果该thread是进程中的最后一个非守护线程（non-daemon thread），那JVM也会死掉。

5. 使用javap -v Sample.class查看byte code中异常相关的信息


