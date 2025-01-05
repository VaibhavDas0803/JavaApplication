# Use a Maven base image to build the application
FROM maven:3.8.1-openjdk-11-slim AS build

# Set the working directory
WORKDIR /app

# Copy the pom.xml and source code into the container
COPY pom.xml .
COPY src ./src

# Set JAVA_HOME (if needed)
ENV JAVA_HOME=/usr/lib/jvm/java-11-openjdk

# Run Maven build with debug output
RUN mvn clean install -X

# Use a smaller JRE base image to run the app
FROM openjdk:11-jre-slim

# Set the working directory for the app
WORKDIR /app

# Copy the built jar file from the build stage
COPY --from=build /app/target/java-application.jar /app/java-application.jar

# Run the Java application
CMD ["java", "-jar", "/app/java-application.jar"]

