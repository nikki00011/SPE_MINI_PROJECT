#FROM openjdk:17
FROM ubuntu:latest

EXPOSE 8080

# Update package lists and install OpenJDK 17 JRE
RUN apt-get update && \
    apt-get install -y openjdk-17-jre

ADD target/spe_mini.jar spe_mini.jar
ENTRYPOINT ["java", "-jar", "/spe_mini.jar"]
