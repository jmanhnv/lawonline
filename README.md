# Our first project!

### Framework & components

##### Pre-Requisites
- Java & JDK Version 1.8 or higher
- Spring MVC 4 (4.3.16.RELEASE)
- Spring Security 4 (4.2.3.RELEASE)
- Thymeleaf 3 (3.0.9.RELEASE)
- Maven 3.x or higher
- Apache Tomcat 7.0.88 (Embedded)
- Apache Lucene (7.3.0)
- Elasticsearch (6.2.4)
- IDE: IntelliJ IDEA 2018.1.4 x64

##### Project structure
```bash
|-- .idea
|-- lib
|-- src
    |-- main
        |-- java
            |-- com.law.lawonline
                |-- common.*
                |-- config.*
                |-- controller.*
                |-- helper.*
        |-- resources
            |-- application.properties
        |-- webapp
            |-- assets/*
            |-- WEB-INF/*
    |-- test
|-- .gitignore
|-- pom.xml
|-- README.md
|-- lawonline.iml
```

##### Build + Deploy + Run application
> Clean compilation products:
```sh
$ mvn clean [install]
```
> Compile:
```sh
$ mvn compile
```
> Run in a tomcat server:
```sh
$ mvn tomcat7:run
```
> Once started, the application should be available at:
```sh
$ http://localhost:8080/
```
