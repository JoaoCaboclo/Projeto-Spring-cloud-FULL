#Start with a base image containing Java runtime
FROM openjdk:17-jdk-slim as build

# Derivando da imagem oficial do MySQL
FROM mysql:8.0.33

#Information around who maintains the image
MAINTAINER https://hub.docker.com/

# Add the application's jar to the container
COPY target/order-service-0.0.1-SNAPSHOT.jar order-service-0.0.1-SNAPSHOT.jar

#execute the application
ENTRYPOINT ["java","-jar","/order-service-0.0.1-SNAPSHOT.jar"]