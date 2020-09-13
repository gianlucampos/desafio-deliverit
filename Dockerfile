FROM openjdk:8
ADD target/testeDeliverIT.jar testeDeliverIT.jar
ENTRYPOINT ["java","-jar","testeDeliverIT.jar"]