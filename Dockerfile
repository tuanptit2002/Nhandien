FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY /target/Be_Java-0.0.1-SNAPSHOT.jar /app/Be_Java-0.0.1-SNAPSHOT.jar

ENV SPRING_PROFILES_ACTIVE=prod

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/Be_Java-0.0.1-SNAPSHOT.jar"]
