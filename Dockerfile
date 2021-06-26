FROM java:8-jdk-alpine
COPY target/spring-reactive-mongo-crud-0.0.1-SNAPSHOT.jar reactive-crud-0.0.1-SNAPSHOT.jar
EXPOSE 9295
ENTRYPOINT ["java", "-jar", "/reactive-crud-0.0.1-SNAPSHOT.jar"]