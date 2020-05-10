FROM maven:3.6.3-jdk-11-slim AS builder
WORKDIR /app
COPY pom.xml ./pom.xml
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn package

FROM openjdk:11-jdk-slim
COPY --from=builder /app/target/*.jar app.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
