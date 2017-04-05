使用Spring Shell实现CLI（同时也可以实现编程式命令模式）

http://www.baeldung.com/spring-shell-cli
https://www.systutorials.com/240129/spring-shell-technology-java-development/

3. 访问Shell
应用中我们有两种主要的方式访问shell
. 第一种是在应用的入口中启动shell，同时让用户输入命令

. 第二种是获取一个JLineShellComponent并以编程方式执行命令
Bootstrap bootstrap = new Bootstrap();
JLineShellComponent shell = bootstrap.getJLineShellComponent();
shell.executeCommand("help");


运行方式 mvn package
运行 target\appassembler\bin\logan-shell.bat
