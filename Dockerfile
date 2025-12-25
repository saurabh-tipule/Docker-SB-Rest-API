FROM eclipse-temurin:8-jre-alpine

WORKDIR /app

COPY target/sb-rest-app.jar sb-rest-app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","sb-rest-app.jar"]
