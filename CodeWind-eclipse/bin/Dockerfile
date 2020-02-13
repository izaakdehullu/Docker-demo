FROM ibmjava:8-sfj
LABEL maintainer="Eclipse Codewind"

COPY target/CWorkspacesDockerEclipse2019spring-boot-1.0-SNAPSHOT.jar /app.jar

ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
