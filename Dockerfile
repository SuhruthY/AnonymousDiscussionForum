# Stage 1: Build
FROM ubuntu:latest AS build

# Install JDK and Maven
RUN apt-get update && apt-get install -y openjdk-17-jdk maven

# Set working directory
WORKDIR /app

# Copy the project files
COPY . .

# Build the application using Maven
RUN mvn clean package -DskipTests

# Stage 2: Run
FROM openjdk:17-jdk-slim

# Expose the application port
EXPOSE 8080

# Copy the built jar from the build stage
COPY --from=build /app/target/*.jar app.jar

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
