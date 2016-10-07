flyway测试

Flyway adheres to the following naming convention for migration scripts:
<Prefix><Version>__<Description>.sql

#source

http://www.baeldung.com/database-migrations-with-flyway

#run
mvn clean flyway:migrate