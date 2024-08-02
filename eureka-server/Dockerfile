FROM openjdk:17-jdk-slim-buster
WORKDIR /app
COPY target/eureka-server-0.1.jar /app/eureka-server.jar
ENTRYPOINT ["java", "-jar", "eureka-server.jar"]
EXPOSE 8761