Lambda和匿名内部类的工作原理（底层）

https://dzone.com/articles/how-lambdas-and-anonymous-inner-classesaic-work

关键点：
. Lambda实现了一个函数式接口
. 匿名内部类可以集成一个类，或者实现一个接口，该类或者接口可以有多个方法
. 变量-lambda只能访问final或者effectively final的变量
. 状态-匿名内部类可以定义和使用实例变量，所以是有状态的，而lambda是无状态的
. 作用域-Lambdas can't define a variable with the same name as a variable in enclosing scope
. 编译-匿名内部类被编译成一个类，而lambda会被编译成一个invokedynamic指令

工作原理

匿名内部类：
. 编译器为每一个匿名内部类生成对应的class文件
例如-AnonymousInnerClass$1.class

. 和所有的类一样，它必须在启动时被加载和确认

Lambda表达式：

lambda实现的本质是InvokeDynamic指令，在Java7中引入。这就允许动态语言在运行时可以绑定symbols

lambda工作原理如下
. 生成invokeddynamic调用点，并使用一个lambdafactory返回functional接口的实现
. Lambda被转换成方法，该方法通过invokedynamic调用
. 该方法作为一个private stattic的方法保存在类中
. 有两种类型的lambda。非捕获的（Non-capturing）lambda只使用方法体内的变量，而捕获的（capturing）lambda会访问它方法体外的变量
                                                                                 

 CFR decompiler反编译器
 http://www.benf.org/other/cfr/