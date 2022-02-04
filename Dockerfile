FROM openjdk:latest
VOLUME /tmp
COPY build/libs/*.jar DiscordWriter-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/DiscordWriter-0.0.1-SNAPSHOT.jar"]