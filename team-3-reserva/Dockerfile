#FROM maven:3.6.0-jdk-11-slim AS build
#COPY src /home/app/src
#COPY pom.xml /home/app
#RUN mvn -f /home/app/pom.xml clean package
#FROM amazoncorretto:11-alpine-jdk
#MAINTAINER MMIT
#COPY out/artifacts/reservas_jar/reservas.jar mmit.jar
#ENTRYPOINT ["java","-jar","mmit.jar"]
#
# Build stage
#
FROM maven:3.8.2-jdk-11 AS build
COPY . .
RUN mvn clean package -Pprod -DskipTests

#
# Package stage
#
FROM openjdk:11-jdk-slim
COPY --from=build /target/reserva-0.0.1-SNAPSHOT.jar reserva.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","demo.jar"]