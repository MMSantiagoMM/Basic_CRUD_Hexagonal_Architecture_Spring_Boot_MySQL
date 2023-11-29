FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17
COPY target/product.jar product.jar
ENTRYPOINT ["java", "-jar","product.jar"]
EXPOSE 8080
