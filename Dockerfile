FROM maven as package

WORKDIR /opt/app/build

COPY pom.xml .
COPY src src

RUN mvn package -DartifactName=app -Dmaven.test.skip=true

FROM openjdk:11 as app

ARG FINAL_NAME=app.jar

WORKDIR /opt/app

COPY --from=package /opt/app/build/target/*.jar ../app.jar

EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/opt/app.jar"]