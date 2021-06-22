FROM amazoncorretto:8

RUN mkdir /opt/apps

WORKDIR /opt/apps

COPY card-insurance-api/build/libs/card-insurance-api.jar ./

EXPOSE 8080

CMD java -jar -Dspring.profiles.active=prod card-insurance-api.jar
