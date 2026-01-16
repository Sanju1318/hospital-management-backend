# ==============================
# STEP 1: Build Stage (Maven)
# ==============================
FROM eclipse-temurin:17-jdk-jammy AS build

WORKDIR /app

COPY pom.xml mvnw ./
COPY .mvn .mvn

RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline

COPY src src

RUN ./mvnw clean package -DskipTests

# ==============================
# STEP 2: Runtime Stage
# ==============================
FROM eclipse-temurin:17-jre-jammy

WORKDIR /app

# Explicit jar copy
COPY --from=build /app/target/HostpitalManagementSystem-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
