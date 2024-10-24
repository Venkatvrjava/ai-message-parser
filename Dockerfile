# Use a base image with JDK
FROM openjdk:17-jdk-alpine
VOLUME /tmp
COPY target/ai-message-parser-0.0.1-SNAPSHOT.jar eco-ai.jar
ENTRYPOINT ["java","-jar","/eco-ai.jar"]
