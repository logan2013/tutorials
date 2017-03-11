https://dzone.com/articles/java-holiday-calendar-2016-day-20-break-out-of-the

Java会间断性地清理heap（也就是说执行Garbage Collector或者简称GC），删除不再使用的对象。
随着heap的增长，清理所需要的时间也随着增长。
最终GC会运行很多秒或者很多分钟，这是我们就遇到了所谓的“GC之战”

减少GC影响的其中一种方式是将数据保存到off heap，那是GC甚至不会检查的地方。
使用这种方式，我们可以任意数据大小，而不用关心GC。
缺陷是必须手工管理memory，同时提供一种方式能够使数据在两个memory regions之间来回转换