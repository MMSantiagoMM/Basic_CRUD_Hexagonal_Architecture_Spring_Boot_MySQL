FROM openjdk:17
COPY target/product.jar product.jar
ENTRYPOINT ["java", "-jar","product.jar"]