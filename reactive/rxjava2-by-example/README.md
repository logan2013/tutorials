https://www.infoq.com/articles/rxjava2-by-example

RXJava2举例
. Reactive编程是一个规范，为了处理异步的数据流

. Java Streams和Lambda表达式是一个有价值的语言增强，但本质上，毕竟它们只是一个迭代集合的方式，同时产生新的集合。
它们是有限的，静态的，而且不提供重用


. Cold observables是到目前为止我们已经讨论过的。它们提供静态的数据。
cold observable的区别点在于只会在有subscriber的时候输送，并且所有的subscriber接收到的是同样的数据，而不管它们是什么时候subscribe的

. Hot observables放好相反，不管有没有subscriber都会输送，如果有subscriber，则输送的是最新的数据

. Cold observable转为hot的步骤
1. 调用Observable的publish方法
2. 调用ConnectableObservable的connect方法开始输送