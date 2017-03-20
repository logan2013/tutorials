Javassist操作二进制文件学习
http://www.baeldung.com/javassist


通过使用高层次的API，Javassist使得操作Java bytecode的过程比JDK所提供的API更加简单

什么是Bytecode
从很高的层次上讲，每一个以纯文本格式写的Java类都会被编译成bytecode - 能够被Java虚拟机处理的指令集。JVM将bytecode指令翻译成为计算机级别的assembly指令

public void move(int, int);
    Code:
       0: aload_0
       1: iload_1
       2: putfield      #2                  // Field x:I
       5: aload_0
       6: iload_2
       7: putfield      #3                  // Field y:I
      10: return
      
我们一起分析move()方法的bytecode
. aload_0指令表示通过local variable 0从stack顶部中读取一个引用（压入栈顶？）
. iload_1从local variable 1中读取一个int值
. putfield是设置成员变量x的值
. 最后的指令是return

Javassist可以用于创建新的Java class文件

Javassist可以读取class的Bytecode指令

Javassist可以给已存在的Class Bytecode增加field

