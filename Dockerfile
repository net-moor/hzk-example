FROM maven as package
MAINTAINER Nukolay Batov <info@netmoor.com>

COPY pom.xml .
COPY src src

RUN mvn package -DartifactName=app -Dmaven.test.skip=true

FROM openjdk:11 as app

COPY --from=package target/*.jar ../app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]