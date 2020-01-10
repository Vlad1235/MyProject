Приложение для работы с базой данных поставщиков пищевой химии.

В приложении используются следующие инструменты:
1. Spring Boot
2. Hibernate
3. RESTful API
4. Liquibase
5. Swagger
6. Postman 

Общедоступная информация о приложении
http://localhost:8080/information/health
http://localhost:8080/information/info
http://localhost:8080/information/liquibase

CRUD операции:
http://localhost:8080/api/suppliers/ - возращает список поставщиков из базы данных
http://localhost:8080/api/supplier/номер - возращает информацию о поставщике из базы данных по указанному параметру
http://localhost:8080/api/supplier/ - сохранение нового поставщика в базу данных
http://localhost:8080/api/supplier/номер - удание поставщика из базы данных по переданному параметру
http://localhost:8080/api/supplier/ - обновление информации о поставщике, перезапись в базу данных

Использование Swagger 
http://localhost:8080/swagger-ui.html
