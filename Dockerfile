FROM maven:alpine
WORKDIR /usr/src/app
COPY . .
RUN mvn clean install -Dmaven.test.skip=true
COPY /usr/src/app/patient-management-system-webapp/target/*.jar app.jar
CMD ["java", "-jar", "app.jar"]