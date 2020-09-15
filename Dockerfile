FROM maven:3.6.1-jdk-8-slim AS build
RUN mkdir -p /workspace
WORKDIR /workspace
COPY pom.xml /workspace
COPY src /workspace/src
RUN mvn clean install -DskipTests

FROM openjdk:8-alpine
COPY --from=build /workspace/target/*.jar testeDeliverIT.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","testeDeliverIT.jar"]
