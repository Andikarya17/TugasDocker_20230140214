FROM eclipse-temurin:25-jdk
ARG JAR_FILE=target/*.jar
COPY ./target/deployment6-0.0.1-SNAPSHOT.jar app.jar
LABEL authors="ACER"

ENTRYPOINT ["java", "-jar", "/app.jar"]
EXPOSE 8080