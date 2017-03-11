http://www.baeldung.com/reactor-core

.. 本质上，Reactive Stream是用于处理异步Stream的一个规范

想象一下每秒钟有成千上万的stock更新信息从金融系统中发出，从而需要及时响应这些更新。

.. 一个应用如果需要成为reactive，首先它必须能够产生一个data stream

.. 在subscribe之前，数据不会开始流动

.. 方法调用的次序
1. onSubscribe() - 当subscribe stream时被调用

2. request(unbounded) - 当调用subscribe方法时，底层创建了一个Subscrption对象。这个对象从stream中请求元素。
它默认是unbounded的，这意味着它会请求每一个可用的元素

3. onNext() - 每一个元素都调用这个方法

4. . onComplete() - 最后被调用，在接收最后一个元素之后。实际上也有onError()方法，在发生异常的时候会被调用

.. 跟Java 8 Streams进行比较
核心的区别是Reactive属于push模型，Java 8 Stream属于pull模型。在reactive方式中，事件一来就会被推送到subscribers

.. 背压是指当下游告诉上游要发送更少的数据量，原因是防止被压垮

.. Hot stream
通过调用publish()方法得到一个ConnectableFlux。这意味着调用subscribe()不会导致开始发出事件，这样就允许增加多个subscription

直到我们调用了connect()方法，Flux才会开始发出事件

.. throttling节流


