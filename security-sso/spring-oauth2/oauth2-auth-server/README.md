https://raymondhlee.wordpress.com/tag/oauth2/

内存认证服务器

测试步骤
1. 浏览器中输入请求授权url，比如：
http://localhost:8080/oauth/authorize?response_type=code&client_id=sampleClientId&redirect_uri=http://client_host?key=value&scope=read

2. 浏览器会重定向到登录页面
http://localhost:8080/login

3. 登录成功后重定向到approve页面，变回请求授权url：
http://localhost:8080/oauth/authorize?response_type=code&client_id=sampleClientId&redirect_uri=http://client_host?key=value&scope=read

4. 选择approve后点击Authorize按钮，则重定向到redirect_uri对应的页面，并附带生成的authorization code，比如：
http://client_host/?key=value&code=RbP2j3

5. 使用authorization code去获取access code，通过POST方法获取：http://localhost:8080/oauth/token
参数包含
redirect_uri：重定向uri，用于校验第1步的uri
grant_type：授权类型
code：第4步获取的authorization code

比如：
redirect_uri=http://client_host?key=value&grant_type=authorization_code&code=UG8zRo


接下来实现：

resource owner信息保存到数据库，本示例保存在内存，hello/world

oauth2 client信息保存到数据，本示例保存在内存，simpleClient/secret

认证使用jwt