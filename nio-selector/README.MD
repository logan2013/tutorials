source: http://www.baeldung.com/java-nio-selector

we can attach an object to a SelectionKey. 
Sometimes we may want to give a channel a custom ID or attach any kind of Java object we may want to keep track of

selector's select method
This method blocks until at least one channel is ready for an operation.
The integer returned represents then number of keys whose channels are ready for an operation

TODO: 客户端使用wrap方法，每次都新建一个ByteBuffer对象？？