FROM maven as package

COPY pom.xml .
COPY src src

RUN mvn package -DartifactName=app -Dmaven.test.skip=true

FROM openjdk:11 as app

ARG FINAL_NAME=app.jar

COPY --from=package target/*.jar ../app.jar

EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]