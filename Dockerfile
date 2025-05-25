# Use an Amazon Corretto base image
FROM amazoncorretto:17

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/ExpenseTracker_User-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your application runs on
EXPOSE 8092

# Run the JAR file
ENTRYPOINT ["java","-Dspring.profiles.active=docker", "-jar", "app.jar"]