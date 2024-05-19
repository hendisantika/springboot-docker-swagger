# Create a new image for running the application
FROM eclipse-temurin:21-alpine
#ARG JAR_FILE=build/libs/*.jar
#COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]
RUN mkdir /app

COPY app.jar /app/app.jar

WORKDIR /app

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
