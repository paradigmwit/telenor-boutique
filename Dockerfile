FROM adoptopenjdk/openjdk11:alpine-jre
WORKDIR /opt/app
COPY telenor-boutique-${version}.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
