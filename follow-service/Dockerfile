FROM openjdk:17-jdk-slim-buster
WORKDIR /app
COPY target/follow-service-0.1.jar /app/follow-service.jar
ENTRYPOINT ["java", "-jar", "follow-service.jar"]
EXPOSE 8080