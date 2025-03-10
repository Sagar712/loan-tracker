FROM openjdk:17
WORKDIR /app

COPY loantracker-0.0.1-SNAPSHOT.jar /app/loantracker-0.0.1-SNAPSHOT.jar

EXPOSE 8088

ENTRYPOINT ["java", "-jar", "loantracker-0.0.1-SNAPSHOT.jar"]