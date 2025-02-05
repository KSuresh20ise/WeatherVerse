# Use an OpenJDK base image
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the jar file from target directory to the container
COPY target/weatherverse-0.0.1-SNAPSHOT.jar /app/weatherverse.jar


# Expose the port your app will run on
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "weatherverse.jar"]
