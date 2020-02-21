FROM wildfly:10.1.0-jdk-8
LABEL maintainer="Izaak de Hullu <izaak.de.hullu@systemtion.nl>"

USER root
WORKDIR /opt
#Add EBX zaken
RUN mkdir ebx/  \
    && chown -R wildfly:0 ebx/ \
    && chmod -R g+rw ebx/
#COPY ebx.properties ebx/

WORKDIR /opt/wildfly
USER wildfly 

# Add EBX settings to configuration
COPY standalone.conf bin/

# Datasource settings
RUN mkdir -p modules/system/layers/base/org/postgres/main/
COPY postgresql-42.2.6.jar modules/system/layers/base/org/postgres/main/

# run config
ENV DB_HOST=db DB_PORT=5432 DB_NAME=ebxDatabase DB_USER=ebx DB_PWD=ebx

ADD wildfly-static-config.cli /tmp/wildfly-static-config.cli

RUN ${WILDFLY_HOME}/bin/jboss-cli.sh --file=/tmp/wildfly-static-config.cli && \
    rm -rf /opt/wildfly/standalone/configuration/standalone_xml_history/

VOLUME /opt/ebx
VOLUME /opt/wildfly/standalone/deployments

CMD ["/opt/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]