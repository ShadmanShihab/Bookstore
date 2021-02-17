FROM adoptopenjdk:11-jre-hotspot

EXPOSE 8087

WORKDIR /app

COPY target/demo-0.0.1-SNAPSHOT.jar .

ENTRYPOINT [ "java", "-jar", "demo-0.0.1-SNAPSHOT.jar" ]