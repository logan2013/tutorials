https://www.javacodegeeks.com/2016/12/implement-thread-pool-java.html
https://dzone.com/articles/scalable-java-thread-pool-executor

如何实现一个线程池

1. 线程池代表一组执行task的worker线程，每个线程可以重复利用多次。当一个新的task提交时，而所有的线程都处于活跃状态，它会在一个queue等待，直到其中一个线程可用