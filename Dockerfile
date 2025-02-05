# Stage 1: Build the application using Maven
FROM maven:3.8.7-openjdk-17-slim AS build

WORKDIR /app

# Copy pom.xml and download dependencies first (to utilize caching)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy source code and build the application
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run the application using a minimal OpenJDK image
FROM openjdk:17-jdk-alpine

WORKDIR /app

# Copy the JAR from the build stage
COPY --from=build /app/target/weatherverse-0.0.1-SNAPSHOT.jar /app/weatherverse.jar

EXPOSE 8080

CMD ["java", "-jar", "weatherverse.jar"]
