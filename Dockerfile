FROM openjdk:17
EXPOSE 8080
ADD target/spe_mini.jar spe_mini.jar
ENTRYPOINT ["java", "-jar", "/spe_mini.jar"]
