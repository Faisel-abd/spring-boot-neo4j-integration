FROM maven:3.6.3-openjdk-15-slim as builder
# install curl
RUN apt-get update && apt-get install -y curl
# image layer
WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw mvnw.cmd pom.xml ./

# Image layer: with the application
COPY src ./src
RUN mvn verify clean --fail-never
RUN --mount=type=cache,target=/app/.m2 mvn clean package -DskipTests
LABEL maintainer="faisel"

# Use a lightweight base image for the runtime environment
FROM eclipse-temurin:17-jre-ubi9-minimal

# Set the working directory in the runtime environment
WORKDIR /app

# Copy the built JAR file from the builder stage
COPY --from=builder /app/target/spring-boot-neo4j-integration-0.0.1-SNAPSHOT.jar /app/app.jar

RUN chmod +x app.jar
# Set the command to run the application
ENTRYPOINT ["java","-jar"]
CMD ["app.jar"]
EXPOSE 8081
