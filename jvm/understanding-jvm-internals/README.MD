理解JVM的内部

https://dzone.com/articles/understanding-jvm-internals

. class文件是人类无法理解的二进制文件。为管理这个文件，JVM提供商提供了javap，反编译器。使用javap的结果叫做Java重组

. Java字节码中有4种调用方法的操作码（OpCodes）
invokeinterface：调用接口方法
invokespecial：Invokes an initializer, private method, or superclass method
invokestatic：调用静态方法
invokevirtual：调用成员方法

. javap反编译出来的代码中，一行表示一个指令。指令包含操作符（OpCode），如aload_0和aload_1。
一些指令后面还会包含操作数（Operand），如invokevirtual。操作符以1个字节表示，操作数以两个字节表示

. javap反编译出来的的代码最前面的数字表示字节编号（第几个字节）从0开始。

字节码指令的操作码（OpCodes），例如 aload_0, getfield, and invokevirtual（aload_0 = 0x2a, getfield = 0xb4, invokevirtual = 0xb6），
用1个字节（1-byte）表示。也就是说，操作码的最大值是256（0xff）。

操作数用2个字节（2-byte）表示

因此，add方法的代码，第0个字节是aload_0，第1个字节是getfield，第2-3字节是#18，第4个字节是aload_1

它对应的16进制码是：2a b4 00 0f 2b b6 00 17 57 b1

# 如何使用javap反编译二进制码
进入target/classes目录下，运行javap -c com.nhn.user.UserService

输出结果如下

Compiled from "UserService.java"
public class com.nhn.user.UserService {
  public com.nhn.user.UserService();
    Code:
       0: aload_0
       1: invokespecial #10                 // Method java/lang/Object."<init>":()V
       4: return

  public void add(java.lang.String);
    Code:
       0: aload_0
       1: getfield      #18                 // Field admin:Lcom/nhn/user/UserAdmin;
       4: aload_1
       5: invokevirtual #20                 // Method com/nhn/user/UserAdmin.add User:(Ljava/lang/String;)V
       8: return
}

add方法的第四行（5: invokevirtual #20）表示调用方法。V表示无返回值

. 符号引用
在Java中，类会被编译成class文件。在编译时，Java类并不知道其引用类的实际内存地址，因此只能使用符号来代替。
比如org.simple.People类引用了org.simple.Tool类，在编译时People类并不知道Tool类的实际内存地址，
因此只能使用符号org.simple.Tool（假设，实际是#数字）来表示Tool类的内存地址。而在类加载器加载People类时，可以通过虚拟机获取Tool类的实际内存地址，
此时便可以将符号替换为org.simple.Tool替换为Tool类的实际内存地址，即直接引用地址。