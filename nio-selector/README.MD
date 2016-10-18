source: http://www.baeldung.com/java-nio-selector

we can attach an object to a SelectionKey. 
Sometimes we may want to give a channel a custom ID or attach any kind of Java object we may want to keep track of

selector's select method
This method blocks until at least one channel is ready for an operation.
The integer returned represents then number of keys whose channels are ready for an operation

wrap和put的区别
1. wrap是静态方法，返回一个ByteBuffer对象；put是成员方法
2. wrap返回的ByteBuffer对象的postion从0开始，put后position递增，读写时需要先调用flip方法