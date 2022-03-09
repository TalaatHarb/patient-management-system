FROM maven:3.8.4-openjdk-17-slim as maven
WORKDIR /usr/src/app
COPY . .
RUN mvn -DskipTests clean compile package > /dev/null

FROM openjdk:17.0.2-jdk-slim
COPY --from=maven /usr/src/app/patient-management-system-webapp/target/patient-management-system-webapp-0.0.1-SNAPSHOT-runnable.jar app.jar
CMD ["java", "-jar", "app.jar"]