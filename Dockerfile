FROM maven:3.6.0-alpine AS build
COPY . home/app/

WORKDIR home/app/

RUN mvn clean package -Dmaven.test.skip=true

FROM java:8-jdk-alpine

COPY --from=build home/app/target/web-app.jar usr/app/

WORKDIR usr/app/
EXPOSE 8080
ENTRYPOINT java -jar web-app.jar