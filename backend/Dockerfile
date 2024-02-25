FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY /build/libs/itmo_web_4.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]