FROM adoptopenjdk/openjdk15:alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
EXPOSE 6000
ARG OUTPUT_FOLDER=build/libs/
COPY ${OUTPUT_FOLDER} /app/lib
ADD src/main/resources/application.yml /app/lib/application.yml
ADD keystore.p12 /app/lib/keystore.p12
WORKDIR /app/lib
ENTRYPOINT ["java","-jar","triddy-0.0.1-SNAPSHOT.jar"]