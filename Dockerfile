FROM java:8-jdk-alpine

COPY ./target/web-app.jar /usr/app/

WORKDIR /usr/app/

ENTRYPOINT java -jar web-app.jar