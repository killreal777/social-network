FROM openjdk:17-jdk-slim-buster
WORKDIR /app
COPY target/translate-service-0.1.jar /app/translate-service.jar
ENTRYPOINT ["java", "-jar", "translate-service.jar"]
EXPOSE 8080