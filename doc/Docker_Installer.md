Following commands will download the docker file for ontobrowser, build it, and run it.


```bash
$ curl -Lo "docker.tar.xz" "https://raw.githubusercontent.com/nikhitajatain/ontobrowser/master/docker/docker.tar.xz"
$ tar xf docker.tar.xz
$ cd docker
$ docker build -t ontobrowser .
$ docker run --name ontobrowser ontobrowser:latest
```

##Local development using Docker
At present there is no docker-compose in place for smooth local development.
If you would like to use Docker for local development nonetheless, Maven and Docker are required.

First build an image and run it with application and db (optional) ports exposed locally.
```bash
$ cd docker
$ docker build -t ontobrowser .
$ docker run --name ontobrowser -p 3306:3306 -p 8080:8080 ontobrowser:latest
```
Then to have your changes deployed in the containerized Wildfly do a Maven clean package
 and replace the .war file in your running container with the newly created one.
```bash
$ mvn clean package
$ cd ../target
$ docker cp ontobrowser.war ontobrowser:/wildfly-14.0.1.Final/standalone/deployments/ROOT.war
```


