FROM centos:7
LABEL maintainer="Izaak de Hullu <izaak.de.hullu@systemtion.nl>" 

# Install packages necessary to run EAP
RUN yum update -y && yum -y install xmlstarlet saxon augeas bsdtar unzip java-1.8.0-openjdk-devel && yum clean all

# Create a user and group used to launch processes
# The user ID 1000 is the default for the first "regular" user on Fedora/RHEL,
# so there is a high chance that this ID will be equal to the current user
# making it easier to use volumes (no permission issues)
RUN groupadd -r wildfly -g 1000 && useradd -u 1000 -r -g wildfly -m -d /opt/wildfly -s /sbin/nologin -c "wildfly user" wildfly && \
    chmod 755 /opt/wildfly

# Set the working directory to wildfly' user home directory
WORKDIR /opt/wildfly

# Set the JAVA_HOME variable to make it clear where Java is located
ENV JAVA_HOME /usr/lib/jvm/java

# Set the WILDFLY_VERSION env variable
ENV WILDFLY_VERSION 10.1.0.Final
ENV WILDFLY_SHA1 7e40059957b7fc28446505c1b67d7947533ba0e9
ENV WILDFLY_HOME /opt/wildfly

# Add the WildFly distribution to /opt, and make wildfly the owner of the extracted tar content
# Make sure the distribution is available from a well-known place
RUN cd $HOME \
    && curl -O https://download.jboss.org/wildfly/$WILDFLY_VERSION/wildfly-$WILDFLY_VERSION.tar.gz \
    && tar xf wildfly-$WILDFLY_VERSION.tar.gz \
    && mv $HOME/wildfly-$WILDFLY_VERSION/* $WILDFLY_HOME \
    && rm wildfly-$WILDFLY_VERSION.tar.gz \
    && chown -R wildfly:0 ${WILDFLY_HOME} \
    && chmod -R g+rw ${WILDFLY_HOME}

# Ensure signals are forwarded to the JVM process correctly for graceful shutdown
ENV LAUNCH_JBOSS_IN_BACKGROUND true

# Specify the user which should be used to execute all commands below
USER wildfly

# add admin user to wildfly
RUN bin/add-user.sh admin admin --silent

# Expose the ports we're interested in
EXPOSE 8080 8787 9990

# Set the default command to run on boot
# This will boot WildFly in the standalone mode and bind to all interface
CMD ["/opt/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]