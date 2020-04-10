# Spring boot application with OpenAPI Specification and MongoDB

Example project with java, Maven, Spring Boot, JUnit, Docker and OpenAPI 3.0 specification

* Java 1.8 or above
* Spring Boot with embedded Tomcat
* Swagger
* MongoDB
* Maven
* Docker

## Clone
Clone this repo to your local machine using: 

``` 
git clone https://github.com/aymen94/springboot-openapi-mongodb
```

## Config MongoDB

* setup configuration of MongoDB in src/main/resources/application.yaml
* or use Docker container [mongo-alpine](https://hub.docker.com/r/aymen94/mongodb-alpine/)

## How to start the app
To campile application you can use Mavne with command:

```
mvn clean package
```

run package with java command:

```
java -jar target/mywebserviceapp-0.0.1-SNAPSHOT.jar
```

or use Docker:

```
docker build .
```

Or you can compile and run with Maven command: 

```
mvn spring-boot:run
```

after followed above command,  the web server is started at the http://localhost:8080.

# Useful commands
Useful cURL or Postman to test. It can be tested with swagger also: http://localhost:8080/swagger-ui.html
