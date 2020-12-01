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
RUN mkdir .tmp_onto && cd .tmp_onto \
    && curl -Lo "mysql.tar.xz" "https://dev.mysql.com/get/Downloads/Connector-J/mysql-connector-java-8.0.13.zip" \
    && unzip "mysql.tar.xz" -d "mysqlj" \
    && curl -Lo "wildfly.tar.gz" "https://download.jboss.org/wildfly/14.0.1.Final/wildfly-14.0.1.Final.tar.gz" \
    && tar -xvzf "wildfly.tar.gz" \
    && mkdir -p "wildfly-14.0.1.Final/modules/system/layers/base/com/mysql/main" \
    && cp "mysqlj/mysql-connector-java-8.0.13/mysql-connector-java-8.0.13.jar" "wildfly-14.0.1.Final/modules/system/layers/base/com/mysql/main" \
    && curl -Lo "wildfly-14.0.1.Final/modules/system/layers/base/com/mysql/main/module.xml" https://raw.githubusercontent.com/mi-erasmusmc/ontobrowser/new_endpoint/wildfly_mysql_config/module.xml \
    && curl -Lo "wildfly-14.0.1.Final/standalone/configuration/standalone.xml" https://raw.githubusercontent.com/mi-erasmusmc/ontobrowser/new_endpoint/wildfly_mysql_config/standalone-local.xml \
    && curl -Lo "wildfly-14.0.1.Final/standalone/deployments/ROOT.war" https://github.com/mi-erasmusmc/ontobrowser/raw/new_endpoint/target/ontobrowser.war \
    && chmod o+r wildfly-14.0.1.Final/standalone/configuration/* \
    && mv wildfly-14.0.1.Final ../ \
    && cd .. && rm -rf .tmp_onto

# Downloading Mysql files
RUN curl -Ok https://raw.githubusercontent.com/mi-erasmusmc/ontobrowser/master/mysql/create_schema_mysql.sql
RUN curl -Ok https://raw.githubusercontent.com/mi-erasmusmc/ontobrowser/master/mysql/insert_initial_data_mysql.sql
RUN curl -Ok https://raw.githubusercontent.com/mi-erasmusmc/ontobrowser/master/mysql/insert_crtld_vocab_example.sql
RUN curl -Ok https://raw.githubusercontent.com/mi-erasmusmc/ontobrowser/master/mysql/insert_curator_mysql.sql

#Downloading ontologies and codelists

RUN curl -Ok https://raw.githubusercontent.com/mi-erasmusmc/ontobrowser/master/ontologies/hpath.obo
RUN curl -Ok https://raw.githubusercontent.com/mi-erasmusmc/ontobrowser/master/ontologies/in-life_observation.obo
RUN curl -Ok https://raw.githubusercontent.com/mi-erasmusmc/ontobrowser/master/ontologies/ma.obo
RUN curl -Ok https://raw.githubusercontent.com/mi-erasmusmc/ontobrowser/master/ontologies/moa.obo

RUN curl -Ok https://raw.githubusercontent.com/mi-erasmusmc/ontobrowser/master/codelists/code_list.obo/terms_C66729.obo
RUN curl -Ok https://raw.githubusercontent.com/mi-erasmusmc/ontobrowser/master/codelists/code_list.obo/terms_C66732.obo
RUN curl -Ok https://raw.githubusercontent.com/mi-erasmusmc/ontobrowser/master/codelists/code_list.obo/terms_C67154.obo
RUN curl -Ok https://raw.githubusercontent.com/mi-erasmusmc/ontobrowser/master/codelists/code_list.obo/terms_C77530.obo
RUN curl -Ok https://raw.githubusercontent.com/mi-erasmusmc/ontobrowser/master/codelists/code_list.obo/terms_C77808.obo
RUN curl -Ok https://raw.githubusercontent.com/mi-erasmusmc/ontobrowser/master/codelists/code_list.obo/terms_C85493.obo


# add our user and group first to make sure their IDs get assigned consistently, regardless of whatever dependencies get added
RUN groupadd -r mysql && useradd -r -g mysql mysql

RUN apt-get update && apt-get install -y --no-install-recommends gnupg dirmngr && rm -rf /var/lib/apt/lists/*

# add gosu for easy step-down from root
ENV GOSU_VERSION 1.7
RUN set -x \
    && apt-get update && apt-get install -y --no-install-recommends ca-certificates wget && rm -rf /var/lib/apt/lists/* \
    && wget -O /usr/local/bin/gosu "https://github.com/tianon/gosu/releases/download/$GOSU_VERSION/gosu-$(dpkg --print-architecture)" \
    && wget -O /usr/local/bin/gosu.asc "https://github.com/tianon/gosu/releases/download/$GOSU_VERSION/gosu-$(dpkg --print-architecture).asc" \
    && export GNUPGHOME="$(mktemp -d)" \
    && gpg --batch --keyserver ha.pool.sks-keyservers.net --recv-keys B42F6819007F00F88E364FD4036A9C25BF357DD4 \
    && gpg --batch --verify /usr/local/bin/gosu.asc /usr/local/bin/gosu \
    && gpgconf --kill all \
    && rm -rf "$GNUPGHOME" /usr/local/bin/gosu.asc \
    && chmod +x /usr/local/bin/gosu \
    && gosu nobody true \
    && apt-get purge -y --auto-remove ca-certificates wget

RUN mkdir /docker-entrypoint-initdb.d

RUN apt-get update && apt-get install -y --no-install-recommends \
# for MYSQL_RANDOM_ROOT_PASSWORD
        pwgen \
# for mysql_ssl_rsa_setup
        openssl \
# FATAL ERROR: please install the following Perl modules before executing /usr/local/mysql/scripts/mysql_install_db:
# File::Basename
# File::Copy
# Sys::Hostname
# Data::Dumper
        perl \
    && rm -rf /var/lib/apt/lists/*

RUN set -ex; \
# gpg: key 5072E1F5: public key "MySQL Release Engineering <mysql-build@oss.oracle.com>" imported
    key='A4A9406876FCBD3C456770C88C718D3B5072E1F5'; \
    export GNUPGHOME="$(mktemp -d)"; \
    gpg --batch --keyserver ha.pool.sks-keyservers.net --recv-keys "$key"; \
    gpg --batch --export "$key" > /etc/apt/trusted.gpg.d/mysql.gpg; \
    gpgconf --kill all; \
    rm -rf "$GNUPGHOME"; \
    apt-key list > /dev/null

ENV MYSQL_MAJOR 8.0
ENV MYSQL_VERSION 8.0.22-1debian10

RUN echo "deb http://repo.mysql.com/apt/debian/ buster mysql-${MYSQL_MAJOR}" > /etc/apt/sources.list.d/mysql.list

# the "/var/lib/mysql" stuff here is because the mysql-server postinst doesn't have an explicit way to disable the mysql_install_db codepath besides having a database already "configured" (ie, stuff in /var/lib/mysql/mysql)
# also, we set debconf keys to make APT a little quieter
RUN { \
        echo mysql-community-server mysql-community-server/data-dir select ''; \
        echo mysql-community-server mysql-community-server/root-pass password ''; \
        echo mysql-community-server mysql-community-server/re-root-pass password ''; \
        echo mysql-community-server mysql-community-server/remove-test-db select false; \
    } | debconf-set-selections \
    && apt-get update && apt-get install -y mysql-community-client="${MYSQL_VERSION}" mysql-community-server-core="${MYSQL_VERSION}" && rm -rf /var/lib/apt/lists/* \
    && rm -rf /var/lib/mysql && mkdir -p /var/lib/mysql /var/run/mysqld \
    && chown -R mysql:mysql /var/lib/mysql /var/run/mysqld \
# ensure that /var/run/mysqld (used for socket and lock files) is writable regardless of the UID our mysqld instance ends up having at runtime
    && chmod 777 /var/run/mysqld

VOLUME /var/lib/mysql
# Config files
COPY config/ /etc/mysql/

COPY docker-entrypoint.sh /usr/local/bin/
RUN chmod 777 /usr/local/bin/docker-entrypoint.sh
COPY schema-creator.sh /schema-creator.sh
RUN chmod 777 /schema-creator.sh
COPY load-ontologies.sh /load-ontologies.sh
RUN chmod 777 /load-ontologies.sh

RUN ln -s usr/local/bin/docker-entrypoint.sh /entrypoint.sh # backwards compat
ENTRYPOINT ["docker-entrypoint.sh"]

RUN chmod -R a+w /wildfly-14.0.1.Final

EXPOSE 3306 33060 8080
CMD ["mysqld"]
