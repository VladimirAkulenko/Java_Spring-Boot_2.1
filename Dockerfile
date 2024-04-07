#FROM openjdk:17-jdk-slim-buster
FROM openjdk:8-jdk-alpine

EXPOSE 9999

ADD target/SpringBootREST-0.0.1-SNAPSHOT.jar spingBootRest.jar

CMD ["java", "-jar", "spingBootRest.jar"]