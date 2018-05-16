FROM openjdk:8-jre
VOLUME /tmp

ARG JAR_FILE

COPY ${JAR_FILE} app.jar

ENV rabbitmq.host "localhost"
ENV rabbitmq.port=5672
ENV rabbitmq.username "guest"
ENV rabbitmq.password "guest"
ENV rabbitmq.exchangeName="eiffel"

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
