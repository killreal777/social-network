FROM openjdk:17-jdk-slim-buster
WORKDIR /app
COPY target/user-service-0.1.jar /app/user-service.jar
ENTRYPOINT ["java", "-jar", "user-service.jar"]
EXPOSE 8080