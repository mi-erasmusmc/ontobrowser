Download the Mysql Docker file

Building Docker OntoBrowser Installer
---
## Installation Requirements

* Graphviz :- RUN apt-get update && apt-get install -y graphviz
* Curl :- RUN apt-get update && apt-get install -y curl
* Unzip:- RUN apt-get update && apt-get install -y unzip
* Java:- RUN curl -Lo java.tar.gz (https://github.com/AdoptOpenJDK/openjdk8-binaries/releases/download/jdk8u222-b10/OpenJDK8U-    jre_x64_linux_hotspot_8u222b10.tar.gz)
 tar -xvzf java.tar.gz

## Loading Mysql files

Mysql files can be loadedas:-

```bash
$ curl -OK https://raw.githubusercontent.com/nikhitajatain/ontobrowser/master/mysql/create_schema_mysql.sql
$ curl -OK https://raw.githubusercontent.com/nikhitajatain/ontobrowser/master/mysql/insert_initial_data_mysql.sql
$ curl -OK https://raw.githubusercontent.com/nikhitajatain/ontobrowser/master/mysql/insert_crtld_vocab_example.sql
$ curl -OK https://raw.githubusercontent.com/nikhitajatain/ontobrowser/master/mysql/insert_curator_mysql.sql
```

## Loading an Ontology
Ontologies can be loaded into OntoBrowser as follows:-

```bash
$ curl -OK https://raw.githubusercontent.com/nikhitajatain/ontobrowser/master/ontologies/hpath.obo
$ curl -OK https://raw.githubusercontent.com/nikhitajatain/ontobrowser/master/ontologies/in-life_observation.obo
$ curl -OK https://raw.githubusercontent.com/nikhitajatain/ontobrowser/master/ontologies/ma.obo
$ curl -OK https://raw.githubusercontent.com/nikhitajatain/ontobrowser/master/ontologies/moa.obo
```
## Loading Codelist
Codelist can be loaded into OntoBrowser as follows:-

```bash
$ curl -OK https://raw.githubusercontent.com/nikhitajatain/ontobrowser/master/codelists/code_list.obo/terms_C66729.obo
$ curl -OK https://raw.githubusercontent.com/nikhitajatain/ontobrowser/master/codelists/code_list.obo/terms_C66732.obo
$ curl -OK https://raw.githubusercontent.com/nikhitajatain/ontobrowser/master/codelists/code_list.obo/terms_C67154.obo
$ curl -OK https://raw.githubusercontent.com/nikhitajatain/ontobrowser/master/codelists/code_list.obo/terms_C77530.obo
$ curl -OK https://raw.githubusercontent.com/nikhitajatain/ontobrowser/master/codelists/code_list.obo/terms_C77808.obo
$ curl -OK https://raw.githubusercontent.com/nikhitajatain/ontobrowser/master/codelists/code_list.obo/terms_C85493.obo
```

## Installing wildfly and ontobrowser

```bash 

RUN mkdir .tmp_onto && cd .tmp_onto \
$ curl -Lo "mysql.tar.xz" "https://dev.mysql.com/get/Downloads/Connector-J/mysql-connector-java-8.0.13.zip" \
$ unzip "mysql.tar.xz" -d "mysqlj" \
$ curl -Lo "wildfly.tar.gz" "https://download.jboss.org/wildfly/14.0.1.Final/wildfly-14.0.1.Final.tar.gz" \
$ tar -xvzf "wildfly.tar.gz" \
$ mkdir -p "wildfly-14.0.1.Final/modules/system/layers/base/com/mysql/main" \
$ cp "mysqlj/mysql-connector-java-8.0.13/mysql-connector-java-8.0.13.jar" "wildfly-14.0.1.Final/modules/system/layers/base/com/mysql/main" \
$ curl -Lo "wildfly-14.0.1.Final/modules/system/layers/base/com/mysql/main/module.xml" https://raw.githubusercontent.com/nikhitajatain/ontobrowser/master/wildfly_mysql_config/module.xml \
$ curl -Lo "wildfly-14.0.1.Final/standalone/configuration/standalone.xml" https://raw.githubusercontent.com/nikhitajatain/ontobrowser/master/wildfly_mysql_config/standalone.xml \
$ curl -Lo "wildfly-14.0.1.Final/standalone/deployments/ontobrowser.war" https://github.com/nikhitajatain/ontobrowser/raw/master/target/ontobrowser.war \
$ chmod o+r wildfly-14.0.1.Final/standalone/configuration/* \
$ mv wildfly-14.0.1.Final ../ \
$ cd .. && rm -rf .tmp_onto

```
