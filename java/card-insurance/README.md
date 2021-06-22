# Introduction 
This is a template for use as base for new services.

#### Getting Started
For running this project it's necessary install some items:
-Gradle
-Docker
-Java 8

#### Technologies
* Java 8
* Spring Boot
* Spring Data JDBC
* WebFlux
* Postgres
* Docker
* FlyWay

#### Build and Test
For building and running the test is only run the commands below in the terminal:

```
docker-compose up
```
This command above is to up the database with necessary scripts 

```
gradle clean buid bootRun
```
The last command is download the dependencies and running the application listening on port 8080.

#### How to generate dockerfile

To generate dockerfile image locally, it's necessary run the command below:

```
docker build -t tiagobm564/card-insurance .
```

To run the image locally, it's just run the following command:

```
docker run --network card-insurance_network-backend -p 9090:8080 tiagobm564/card-insurance
```

Warning: docker-compose it's necessary is up.

To publish the image in docker hub, run the command below:
```
docker push tiagobm564/card-insurance
```
#### Using Jacoco to test coverage

To generate the coverage report it's necessary run this task:
```
gradle build coverageReport
```

In the root project build\reports\html\index.html is the report.
