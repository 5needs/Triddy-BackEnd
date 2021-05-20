FROM adoptopenjdk/openjdk11:alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
EXPOSE 8080
ARG OUTPUT_FOLDER=build/libs/
COPY ${OUTPUT_FOLDER} /app/lib
ADD application.yml /app/lib/application.yml
ADD keystore.p12 /app/lib/keystore.p12
WORKDIR /app/lib
ENTRYPOINT ["java","-jar","triddy-0.0.1-SNAPSHOT.jar"]