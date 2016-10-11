空项目，用户记录如何进行GC日志分析

https://dzone.com/articles/understanding-the-java-memory-model-and-the-garbag

https://dzone.com/articles/enabling-and-analysing-the-garbage-collection-log




Note: Set the heap size as low to get the GC log for this exercise:

-XX:+DisableExplicitGC
-XX:+PrintGCDetails
-XX:+PrintGCApplicationStoppedTime
-XX:+PrintGCApplicationConcurrentTime
-XX:+PrintGCDateStamps
-Xloggc:gclog.log
-XX:+UseGCLogFileRotation
-XX:NumberOfGCLogFiles=5
-XX:GCLogFileSize=2000k
Let us understand the purpose of each option. These options may vary based on the OS, JVM vendor, and Java version.

# DisableExplicitGC: By default this option is disabled. Sometimes developers might have invoked garbage collection pragmatically by calling System.gc() or Runtime.getRuntime().gc(). This is not advisable. Hence in production systems we enable this option so that the pragmatic invocation of garbage collection is disabled.

# PrintGCDetails: By default this option is disabled. If we enable this option, the JVM prints more details at each garbage collection.

# PrintGCApplicationStoppedTime: By default this option is disabled. If we enable it, it prints the information on application pause during GC.

# PrintGCApplicationConcurrentTime: By default this option is disabled. If we enable it, it prints the information on application running time during GC.

# PrintGCDateStamps: By default this option is disabled. If we enable it, it prints the date and time details at each GC.

# loggc: This is a string option. We have have to pass the gc log file name. In this file we will get all the GC log information.

# UseGCLogFileRotation: This option makes the JVM rotate the log file if the file size reaches a specified size.

# NumberOfGCLogFiles: The default value is 1. This sets the number of files to use when rotating logs.

# GCLogFileSize: The default value is 8KB, which is the size of the log file before the point the where the log will be rotated.

By setting the above options, we are ready to get the GC log. To tune the JVM, it is better to enable these options during the load test and take the GC log on different loads for analysis. From the GC log we have to observe the below parameters.