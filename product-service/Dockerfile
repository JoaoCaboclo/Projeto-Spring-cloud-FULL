#Start with a base image containing Java runtime
FROM openjdk:17-jdk-slim as build

# Derivando da imagem oficial do MongoDB
FROM mongo:latest

#Information around who maintains the image
MAINTAINER https://hub.docker.com/

# Add the application's jar to the container
COPY target/product-service-0.0.1-SNAPSHOT.jar product-service-0.0.1-SNAPSHOT.jar

#execute the application
ENTRYPOINT ["java","-jar","/product-service-0.0.1-SNAPSHOT.jar"]