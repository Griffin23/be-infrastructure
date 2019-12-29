FROM openjdk:8
ADD controller-1.0.0.jar be-inf.jar
RUN mkdir /var/logs/
EXPOSE 5520
ENTRYPOINT ["java", "-jar", "be-inf.jar"]
