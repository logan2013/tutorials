https://dzone.com/articles/spring-core-dependency-injection

Spring Dependency injection学习

Dependency injection是对象定义它们的依赖的过程，也就是说，它们进行工作所需要的其它对象。通过构造方法、setter方法、工厂方法等等。
容器的职责是在创建bean的时候注入这些对象。依赖注入的存在，我们可以有更简洁的代码和更清晰地解耦。

有两种著名的依赖注入方式
. 基于构造方法
. 基于setter方法

什么时候使用构造方法注入vs. setter方法注入？
根据Spring的文档声明，对于强制的依赖使用构造方法注入，对于可选的依赖使用setter方法注入。
对不变性有帮助，同时也能确保在创建bean之前满足所需的依赖。当然，如果你想重新配置bean，使用setter方法注入

环形依赖
有一种场景当你打开bean，比方说A，依赖与B，而B也依赖于A（双方都通过构造方法表达依赖）。Spring IoC容器在运行时会侦测到这个问题，并且抛出BeanCurrentlyInCreationException异常

可行的解决方法是使用setter注入