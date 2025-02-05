# Stage 1: Build the application
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package

# Stage 2: Run the application
FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/weatherverse-0.0.1-SNAPSHOT.jar weatherverse.jar
EXPOSE 8080
CMD ["java", "-jar", "weatherverse.jar"]
