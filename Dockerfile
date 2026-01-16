# Step 1: Use official OpenJDK 17
FROM openjdk:17-jdk-slim

# Step 2: Set working directory
WORKDIR /app

# Step 3: Copy all project files
COPY . .

# Step 4: Make Maven wrapper executable
RUN chmod +x mvnw

# Step 5: Build the Spring Boot JAR
RUN ./mvnw clean package -DskipTests

# Step 6: Expose port 8080
EXPOSE 8080

# Step 7: Set environment variables for Spring Boot (optional default values)
ENV SPRING_PROFILES_ACTIVE=prod

# Step 8: Start the Spring Boot app
CMD ["java", "-jar", "target/*.jar"]
