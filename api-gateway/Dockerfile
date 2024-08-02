FROM openjdk:17-jdk-slim-buster
WORKDIR /app
COPY target/api-gateway-0.1.jar /app/api-gateway.jar
ENTRYPOINT ["java", "-jar", "api-gateway.jar"]
EXPOSE 8765