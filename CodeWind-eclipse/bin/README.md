## Microservice
Eclipse Codewind Microservice Starter for Spring

### Table of Contents
- [Microservice](#microservice)
  - [Table of Contents](#table-of-contents)
  - [Summary](#summary)
  - [Requirements](#requirements)
  - [Configuration](#configuration)
  - [Project contents](#project-contents)
  - [Run](#run)
  - [Endpoints](#endpoints)
  - [Notices](#notices)

### Summary

The Eclipse Codewind Microservice Starter in Java provides a starting point for creating Java microservice applications running on [Spring](https://spring.io/).

### Requirements
* [Maven](https://maven.apache.org/install.html)
* Java 8: Any compliant JVM should work.
  * [Java 8 JDK from Oracle](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
  * [Java 8 JDK from IBM (AIX, Linux, z/OS, IBM i)](http://www.ibm.com/developerworks/java/jdk/)

### Configuration
Capabilities are provided through dependencies in the pom.xml file.

### Project contents
The ports are set to the defaults of 8080 for http and 8443 for https and are exposed to the CLI in the cli-config.yml file.

### Run

To build and run the application:
1. `mvn install`
2. `java -jar ./target/[microclimate-project-name]-1.0-SNAPSHOT.jar`

To run the application in Docker use the Docker file called `Dockerfile`. If you do not want to install Maven locally you can use `Dockerfile-tools` to build a container with Maven installed.

### Endpoints

The application exposes the following endpoints:

The ports are set in the pom.xml file and exposed to the CLI in the cli-config.yml file.


### Notices

This project was generated using:
* generator-ibm-java v5.13.7
* generator-ibm-service-enablement v3.1.2
* generator-ibm-cloud-enablement v1.5.4
* generator-ibm-java-spring v

