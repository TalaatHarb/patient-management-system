FROM maven:alpine as maven
WORKDIR /usr/src/app
COPY . .
RUN mvn clean install -Dmaven.test.skip=true

FROM openjdk:alpine
COPY --from=maven /usr/src/app/patient-management-system-webapp/target/*.jar app.jar
CMD ["java", "-jar", "app.jar"]