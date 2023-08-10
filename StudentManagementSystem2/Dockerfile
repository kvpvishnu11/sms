# Use an OpenJDK 17 base image
FROM openjdk:17-jdk

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from the local file system to the container
COPY target/StudentManagementSystem-0.0.1-SNAPSHOT.jar StudentManagementSystem-0.0.1-SNAPSHOT.jar

# Expose the port on which the application will run (default is 8080)
EXPOSE 8080

# Set the default values for the environment variables (you can override these during runtime)
ENV DB_URL="default_db_url" \
    DB_USERNAME="default_db_username" \
    DB_PASSWORD="default_db_password"

# Specify the command to run when the container starts, using the environment variables
CMD ["java", "-jar", "StudentManagementSystem-0.0.1-SNAPSHOT.jar", \
    "--spring.datasource.url=${DB_URL}", \
    "--spring.datasource.username=${DB_USERNAME}", \
    "--spring.datasource.password=${DB_PASSWORD}"]
