#NIO
. Channels move blocks of data into and out of buffers to and from various I/O sources such as Socket, datagrams, File and so forth.
. Each SocketChannel is associated with a peer Socket
. SocketChannel.open() does not immediately connect. It creates an initially unconnectetd socket that must be connected later using the connect() method.

. The read() method of SocketChannel
If the channel is blocking, this method will read a least on byte or return -1 or throw an exception
If the channel is nonblocking, however, this method may reaturn 0.

. Just as with regular sockets, you should close a channel when you're done with it to free up the port and any other resource it may using

. ServerSocketChannel.open(). A factory method is rather than a constructor so that different virtual machines can provide different implementations of this class

. *You will also want to remove the key from the iterator to tell the selector that you've handled it.*
  *Otherwise, the selector will keep telling you about it on future passes through the loop* 
  
* A single channel can be registered with multiple selectors

#Netty
. Given that inbound and outbound operations are distinct, you might wonder what happens when the two categories of handlers are mixed in the same ChannelPipeline.
Although inbound and outbound handlers are extend ChannelHandler. Netty distinguishes implementation of ChannelInboundHandler and ChannelOutboundHandler
and ensures that the data is passed only between handlers of the same directional type.

. Any operation whose name starts with read or skip will retrieve or skip the data at the current readerIndex
and increase it by the number of bytes read.

. Any operation whose name starts with write will start writing data at the current writerIndex,
increasing it by the number of bytes written. 

. get() and set() operations that start at a given index and leave it unchanged
. read() and write() operations that start at a given index and adjust it by the number of bytes accessed

. Channel通常的生命周期
ChannelRegistered -> ChannelActive -> ChannelInactive -> ChannelUnregistered

. write并方法不会将message写到底层的Socket，仅仅放到队列里。要写到Socket的话，调用flush()或者writeAndFlush()
