# Use the official OpenJDK base image
FROM openjdk:21-jdk-slim AS build

# Set the working directory in the container
WORKDIR /app

# Copy the WAR file into the container
COPY ./target/deployApp-0.0.1-SNAPSHOT.war /app/app.war

# Expose the port your application will run on
EXPOSE 8083

# Command to run the WAR file
ENTRYPOINT ["java", "-jar", "/app/app.war"]
