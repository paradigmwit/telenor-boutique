FROM adoptopenjdk/openjdk11:alpine-jre
COPY pom.xml /tmp/
COPY src /tmp/src/
WORKDIR /tmp/
RUN mvn package

COPY telenor-boutique*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
