多个版本的兼容问题

http://tech.asimio.net/2017/03/06/Multi-version-Service-Discovery-using-Spring-Cloud-Netflix-Eureka-and-Ribbon.html


1. 打包并启动ureka服务

java -Dspring.profiles.active=standalone -jar target/discoveryserver-0.0.1-SNAPSHOT.jar


2. 打包并启动api1，版本为v1

java -DappPort=8601 -DhostName=localhost -Dspring.profiles.active=v1 -jar target/demo-multiversion-registration-api-1-0.0.1-SNAPSHOT.jar

   启动api1，版本为v1v2
   
java -DappPort=8602 -DhostName=localhost -Dspring.profiles.active=v1v2 -jar target/demo-multiversion-registration-api-1-0.0.1-SNAPSHOT.jar
   

查看注册情况
http://localhost:8000/eureka/apps/DEMO-MULTIVERSION-REGISTRATION-API-1
   
3. 打包并启动api2

java -DappPort=8701 -DhostName=localhost -jar target/demo-multiversion-registration-api-2-0.0.1-SNAPSHOT.jar

4. 访问版本v1
    
   http://localhost:8701/aggregation/v1/actors/1
   http://localhost:8701/aggregation/v1/actors/1
   
   访问两次有不同的结果，是因为做了负载均衡

   访问版本v2
   
   http://localhost:8701/aggregation/v2/actors/1