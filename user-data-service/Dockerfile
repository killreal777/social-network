FROM openjdk:17-jdk-slim-buster
WORKDIR /app
COPY target/user-data-service-0.1.jar /app/user-data-service.jar
ENTRYPOINT ["java", "-jar", "user-data-service.jar"]
EXPOSE 8080