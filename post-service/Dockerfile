FROM openjdk:17-jdk-slim-buster
WORKDIR /app
COPY target/post-service-0.1.jar /app/post-service.jar
ENTRYPOINT ["java", "-jar", "post-service.jar"]
EXPOSE 8080