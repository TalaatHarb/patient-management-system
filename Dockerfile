FROM maven:alpine
WORKDIR /usr/src/app
COPY . .
RUN mvn -B -Dmaven.test.skip=true clean compile package --file pom.xml 
COPY /usr/src/app/patient-management-system-webapp/target/*.jar app.jar
CMD ["java", "-jar", "app.jar"]