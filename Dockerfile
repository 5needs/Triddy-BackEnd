FROM openjdk:15-jdk-alpine
ARG OUTPUT_FOLDER=build/libs/
COPY ${OUTPUT_FOLDER} /app/lib
WORKDIR /app/lib
ENTRYPOINT ["java","-jar","triddy-0.0.1-SNAPSHOT.jar"]