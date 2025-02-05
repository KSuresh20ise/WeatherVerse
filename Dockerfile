# Stage 1: Build the application using Maven
FROM maven:3.8.6-openjdk-17 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy pom.xml and download dependencies first (for caching)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the source code
COPY src ./src

# Package the application
RUN mvn clean package -DskipTests

# Stage 2: Run the application using a minimal OpenJDK image
FROM openjdk:17-jdk-alpine

WORKDIR /app

# Copy the jar from the previous stage
COPY --from=build /app/target/weatherverse-0.0.1-SNAPSHOT.jar /app/weatherverse.jar

# Expose the port your app runs on
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "weatherverse.jar"]
