FROM openjdk:17
COPY build/libs/light-digital-0.0.1-SNAPSHOT.jar light.jar
ENTRYPOINT ["java","-jar","light.jar"]