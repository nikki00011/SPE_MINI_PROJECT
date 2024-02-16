FROM openjdk:8
EXPOSE 8080
ADD target/SPE_MINI.jar SPE_MINI.jar
ENTRYPOINT["java","jar","/SPE_MINI.jar"]