FROM openjdk:11
RUN mkdir /opt/app/
VOLUME /opt/app
EXPOSE 8000
CMD ["java", "-Xdebug", "-Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=8000", "-jar", "/opt/app/app.jar"]
