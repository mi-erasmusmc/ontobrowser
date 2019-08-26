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
$ curl -O https://raw.githubusercontent.com/nikhitajatain/ontobrowser/master/mysql/create_schema_mysql.sql
$ curl -O https://raw.githubusercontent.com/nikhitajatain/ontobrowser/master/mysql/insert_initial_data_mysql.sql
$ curl -O https://raw.githubusercontent.com/nikhitajatain/ontobrowser/master/mysql/insert_crtld_vocab_example.sql
$ curl -O https://raw.githubusercontent.com/nikhitajatain/ontobrowser/master/mysql/insert_curator_mysql.sql
```

## Loading an Ontology
Ontologies can be loaded into OntoBrowser as follows:-

```bash
$ curl -O https://raw.githubusercontent.com/nikhitajatain/ontobrowser/master/ontologies/hpath.obo
$ curl -O https://raw.githubusercontent.com/nikhitajatain/ontobrowser/master/ontologies/in-life_observation.obo
$ curl -O https://raw.githubusercontent.com/nikhitajatain/ontobrowser/master/ontologies/ma.obo
$ curl -O https://raw.githubusercontent.com/nikhitajatain/ontobrowser/master/ontologies/moa.obo
```
## Loading Codelist
Codelist can be loaded into OntoBrowser as follows:-

```bash
$ curl -O https://raw.githubusercontent.com/nikhitajatain/ontobrowser/master/codelists/code_list.obo/terms_C66729.obo
$ curl -O https://raw.githubusercontent.com/nikhitajatain/ontobrowser/master/codelists/code_list.obo/terms_C66732.obo
$ curl -O https://raw.githubusercontent.com/nikhitajatain/ontobrowser/master/codelists/code_list.obo/terms_C67154.obo
$ curl -O https://raw.githubusercontent.com/nikhitajatain/ontobrowser/master/codelists/code_list.obo/terms_C77530.obo
$ curl -O https://raw.githubusercontent.com/nikhitajatain/ontobrowser/master/codelists/code_list.obo/terms_C77808.obo
$ curl -O https://raw.githubusercontent.com/nikhitajatain/ontobrowser/master/codelists/code_list.obo/terms_C85493.obo
```

## Installing wildfly and ontobrowser


