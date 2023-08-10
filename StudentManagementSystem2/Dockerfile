# Use an OpenJDK 11 base image
FROM openjdk:17-jdk

# Set the working directory in the container
WORKDIR /app

# Copy the WAR file from the local file system to the container
COPY target/StudentManagementSystem-0.0.1-SNAPSHOT.jar StudentManagementSystem-0.0.1-SNAPSHOT.jar

# Expose the port on which the application will run (default is 8080)
EXPOSE 8080

# Specify the command to run when the container starts
CMD ["java", "-jar", "StudentManagementSystem-0.0.1-SNAPSHOT.jar"]


