
FROM maven:3.9-eclipse-temurin-17 AS build

WORKDIR /app


COPY pom.xml .

# Download dependencies
RUN mvn dependency:go-offline


COPY src ./src


RUN mvn clean package -DskipTests


# Stage 2: Run application
FROM eclipse-temurin:17-jre

WORKDIR /app

ENV APP_CONF_URL=tcp://postgresql:5432/task_db
# the password will be loaded from Vault
#ENV APP_CONF_USERNAME=admin
ENV APP_CONF_PASSWORD=admin
# Copy the generated JAR from the build stage
COPY --from=build /app/target/*.jar task-service.jar


EXPOSE 8090

ENTRYPOINT ["java", "-jar", "task-service.jar"]