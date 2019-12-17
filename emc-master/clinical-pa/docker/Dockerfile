FROM adoptopenjdk/openjdk11:latest

COPY clinicaltrials-pa.jar ./images/
WORKDIR ./images/

ENTRYPOINT ["java", "-jar", "clinicaltrials-pa.jar"]
EXPOSE 8080
