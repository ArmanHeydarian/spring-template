# Webservice
This is a Java based Web Service consists an API set and Swagger UI for users ...
All the required specifications have been considered completely


### Design:
I have followed OOP, SOLID and Domain Driven Design approach to make an extensible and clean structures.
Each service class has its own Interface for decoupling design from implementation.

### Layers:
#### API: Rest Controllers
#### Service:  Business and Logic
#### Domain: Domain Models and DTO (Request classes)
#### DAO: Data Repository Layer
#### UTIL: Utilities including Custom Exception Handler and Data Convertors

### Used Frameworks and Technologies:
Spring Boot - Spring Web - Spring Data JPA - Maven - Log4J2 , H2 in-memory Database, Swagger - Lombok - FlyWay and Docker

### Build and Run Project
In order to run the project please follow the Instructions below\
1- Open the Project in IntelliJ Idea (Or any other IDE) this project is developed in IntelliJIdea\
2- Build via Maven (mvn clean package) then you will be able to run it via Docker compose (docker-compose up) or IntelliJ Runner\
3- Use Swagger UI for testing the functionality of APIs  through url: http://localhost:8080/swagger-ui.html \
4- For accessing database you can use this url: http://localhost:8080/h2-console \
5- In order to facilitate api testing, this service will prepare some default sample data(this has been done by flyway)  

### Outstanding Features and Interesting Specifications in Implementation:
there are many good Ideas that have made this project extensible, scalable like:
1- Domain Driven Design \
2- Solid and OOP based Design with a clean and understandable code \
3- Multi Layers Structure \
4- Unit and Integration tests for APIs, Domain Model and Domain Services, etc. \
5- A cross-functional utility for handling exceptions and data converting, etc.  \
6- Comprehensive and meaningful logs \
7- A simple Swagger-UI for testing APIS . \



#### Hope it will be satisfying :)
#### Feel free to ask any question.
#### Arman.heydarian@gmail.com

