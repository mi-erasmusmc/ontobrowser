# Deploying Primitive Adapter on Knowledgehub

Deploying primitive adapter needs three steps:- 

  - Build the docker image.
  - Push the docker image on Knowledgehub.
  - Deploy the container of the pushed docker image in the Knowledgehub kubernetes cluster.

## 1. Build and push the docker image

To illustrate this step we will use a sample docker image available at: [https://dockerhub.etransafe.eu/WP9/emc/tree/nikhita/clinical-pa/docker](https://dockerhub.etransafe.eu/WP9/emc/tree/nikhita/clinical-pa/docker)

```sh
$ sudo docker build -t dockerhub.etransafe.eu:5111/wp9/emc/clinicaltrials-pa:latest .
$ sudo docker push dockerhub.etransafe.eu:5111/wp9/emc/clinicaltrials-pa:latest
```
