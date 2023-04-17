FROM openjdk:17
EXPOSE 9000
ARG jarfile=target/product-microservice.jar
ADD ${jarfile} product-microservice.jar
ENTRYPOINT ["java","-jar","/product-microservice.jar"]
