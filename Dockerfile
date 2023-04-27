FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package
FROM amazoncorretto:11-alpine-jdk
MAINTAINER MMIT
COPY out/artifacts/reservas_jar/reservas.jar mmit.jar
ENTRYPOINT ["java","-jar","mmit.jar"]
#
