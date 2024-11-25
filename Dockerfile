# Use a base image with OpenJDK
FROM openjdk:11-jdk-slim as build

# Set the working directory in the container
WORKDIR /app

# Copy the jar file from the local machine to the container
COPY target/employeeServiceSpring-0.0.1-SNAPSHOT.jar /app/employeeServiceSpring-0.0.1-SNAPSHOT.jar

# Expose the port the app will run on
EXPOSE 8081

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "employeeServiceSpring-0.0.1-SNAPSHOT.jar"]
