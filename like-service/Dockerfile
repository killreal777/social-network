FROM openjdk:17-jdk-slim-buster
WORKDIR /app
COPY target/like-service-0.1.jar /app/like-service.jar
ENTRYPOINT ["java", "-jar", "like-service.jar"]
EXPOSE 8000