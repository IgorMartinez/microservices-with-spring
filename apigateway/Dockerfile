FROM amazoncorretto:21.0.3
ARG JAR_FILE=apigateway/target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]