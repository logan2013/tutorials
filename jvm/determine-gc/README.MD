判断程序使用的GC

方法一：One easy approach to determining the selected garbage collector is via use the

-XX:+PrintCommandLineFlags flag

for this project:

java -XX:+PrintCommandLineFlags com.imtzp.determin.gc.App


this result will be

-XX:InitialHeapSize=129621184 -XX:MaxHeapSize=2073938944 -XX:+PrintCommandLineFlags -XX:+UseCompressedClassPointers -XX:+UseCompressedOops -XX:-UseLargePagesIndividualAllocation -XX:+UseParallelGC

方法二，针对运行中的程序

1. 运行jcmd，显示所有Java进程

C:\Users\Administrator>jcmd
5192 sun.tools.jcmd.JCmd
5624
6844 com.imtzp.determine.gc.App

显示6844对应的虚拟机使用的标记
C:\Users\Administrator>jcmd 6844 VM.flags
6844:
-XX:CICompilerCount=3 
-XX:InitialHeapSize=130023424 -XX:MaxHeapSize=2074083328 
-XX:MaxNewSize=691011584 -XX:MinHeapDeltaBytes=524288 -XX:NewSize=42991616 
-XX:OldSize=87031808 -XX:+PrintCommandLineFlags -XX:+UseCompressedClassPointers -XX:+UseCompressedOops 
-XX:+UseFastUnorderedTimeStamps -XX:-UseLargePagesIndividualAllocation -XX:+UseParallelGC