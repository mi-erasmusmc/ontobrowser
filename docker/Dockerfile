# Use latest jboss/base-jdk:11 image as the base
FROM jboss/base-jdk:11

# Set the WILDFLY_VERSION env variable
ENV WILDFLY_VERSION 17.0.1.Final
ENV WILDFLY_SHA1 eaef7a87062837c215e54511c4ada8951f0bd8d5
ENV JBOSS_HOME /opt/jboss/wildfly

USER root

# Add the WildFly distribution to /opt, and make wildfly the owner of the extracted tar content
# Make sure the distribution is available from a well-known place
RUN cd $HOME \
    && yum -y install graphviz \
    && curl -O https://download.jboss.org/wildfly/$WILDFLY_VERSION/wildfly-$WILDFLY_VERSION.tar.gz \
    && sha1sum wildfly-$WILDFLY_VERSION.tar.gz | grep $WILDFLY_SHA1 \
    && tar xf wildfly-$WILDFLY_VERSION.tar.gz \
    && curl -Lo "mysql.tar.xz" "https://dev.mysql.com/get/Downloads/Connector-J/mysql-connector-java-8.0.16.zip" \
    && unzip "mysql.tar.xz" -d "mysqlj" \
    && mkdir -p wildfly-$WILDFLY_VERSION/modules/system/layers/base/com/mysql/main \
    && cp "mysqlj/mysql-connector-java-8.0.16/mysql-connector-java-8.0.16.jar" wildfly-$WILDFLY_VERSION/modules/system/layers/base/com/mysql/main \
    && curl -Lo wildfly-$WILDFLY_VERSION/modules/system/layers/base/com/mysql/main/module.xml https://raw.githubusercontent.com/nikhitajatain/ontobrowser/master/wildfly_mysql_config/module.xml \
    && curl -Lo wildfly-$WILDFLY_VERSION/standalone/configuration/standalone.xml https://raw.githubusercontent.com/nikhitajatain/ontobrowser/master/wildfly_mysql_config/standalone.xml \
    && curl -Lo wildfly-$WILDFLY_VERSION/standalone/deployments/ontobrowser.war https://github.com/nikhitajatain/ontobrowser/raw/master/target/ontobrowser.war \
    && mv $HOME/wildfly-$WILDFLY_VERSION $JBOSS_HOME \
    && rm wildfly-$WILDFLY_VERSION.tar.gz \
    && chown -R jboss:0 ${JBOSS_HOME} \
    && chmod -R g+rw ${JBOSS_HOME}

# Ensure signals are forwarded to the JVM process correctly for graceful shutdown
ENV LAUNCH_JBOSS_IN_BACKGROUND true

USER jboss

# Expose the ports we're interested in
EXPOSE 8080

# Set the default command to run on boot
# This will boot WildFly in the standalone mode and bind to all interface
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0"]
