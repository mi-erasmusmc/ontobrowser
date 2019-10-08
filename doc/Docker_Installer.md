Download the whole docker folder from https://github.com/nikhitajatain/ontobrowser/tree/master/docker


```bash
$ curl -Lo "docker.tar.xz" "https://raw.githubusercontent.com/nikhitajatain/ontobrowser/master/docker/docker.tar.xz"
$ tar xf docker.tar.xz
$ cd docker
$ docker build -t ontobrowser .
$ docker run --name ontobrowser ontobrowser:latest
```


