FROM debian:bullseye

# installing Graphviz
RUN apt-get update && apt-get install -y graphviz

# Installing curl, unzip
RUN apt-get update && apt-get install -y curl
RUN apt-get update && apt-get install -y unzip

#Installing java
RUN curl -Lo java.tar.gz https://github.com/AdoptOpenJDK/openjdk8-binaries/releases/download/jdk8u222-b10/OpenJDK8U-jre_x64_linux_hotspot_8u222b10.tar.gz \
    && tar -xvzf java.tar.gz

ENV JAVA_HOME /jdk8u222-b10-jre

# Installing wildfly and ontobrowser
RUN mkdir onto && cd onto \
    && curl -Lo "mysql.tar.xz" "https://dev.mysql.com/get/Downloads/Connector-J/mysql-connector-java-8.0.13.zip" \
    && unzip "mysql.tar.xz" -d "mysqlj" \
    && curl -Lo "wildfly.tar.gz" "https://download.jboss.org/wildfly/14.0.1.Final/wildfly-14.0.1.Final.tar.gz" \
    && tar -xvzf "wildfly.tar.gz" \
    && mkdir -p "wildfly-14.0.1.Final/modules/system/layers/base/com/mysql/main" \
    && cp "mysqlj/mysql-connector-java-8.0.13/mysql-connector-java-8.0.13.jar" "wildfly-14.0.1.Final/modules/system/layers/base/com/mysql/main" \
    && curl -Lo "wildfly-14.0.1.Final/modules/system/layers/base/com/mysql/main/module.xml" https://raw.githubusercontent.com/mi-erasmusmc/ontobrowser/new_endpoint/wildfly_mysql_config/module.xml


COPY standalone.xml onto/wildfly-14.0.1.Final/standalone/configuration/standalone.xml
COPY ontobrowser.war onto/wildfly-14.0.1.Final/standalone/deployments/ROOT.war


RUN cd onto \
    && chmod o+r wildfly-14.0.1.Final/standalone/configuration/* \
    && mv wildfly-14.0.1.Final ../ \
    && cd .. && rm -rf onto


RUN chmod -R a+w /wildfly-14.0.1.Final

RUN apt -y remove curl
RUN apt -y remove unzip

EXPOSE 8080

CMD ./wildfly-14.0.1.Final/bin/standalone.sh -b 0.0.0.0