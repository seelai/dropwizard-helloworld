FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/dropwizard-helloworld*.jar
ARG HELLOWORLD_YML=target/classes/hello-world.yml
COPY ${JAR_FILE} app.jar
COPY ${HELLOWORLD_YML} hello-world.yml
ENTRYPOINT ["java", "-jar", "/app.jar", "server", "hello-world.yml"]