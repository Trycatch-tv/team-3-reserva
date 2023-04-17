FROM amazoncorretto:11-alpine-jdk
MAINTAINER MMIT
COPY out/artifacts/reservas_jar/reservas.jar mmit.jar
ENTRYPOINT ["java","-jar","mmit.jar"]
