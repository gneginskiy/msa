# Stage 1: Build the application with Gradle
FROM eclipse-temurin:17-jdk-jammy AS builder
WORKDIR /app
# Copy only the necessary files for the build
COPY build.gradle settings.gradle gradlew ./
COPY gradle/ gradle/
COPY src/ src/
# Run the Gradle build
RUN ./gradlew bootJar

# Stage 2: Create a smaller image for running the application
FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app
# Copy only the built JAR file from the previous stage
COPY --from=builder /app/build/libs/otus-msa-0.0.1-SNAPSHOT.jar .
# Expose the default Spring Boot port
EXPOSE 8080
# Set the default command to run the Spring Boot application
CMD ["java", "-jar", "otus-msa-0.0.1-SNAPSHOT.jar"]
