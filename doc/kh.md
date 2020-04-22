# Deploying Primitive Adapter on Knowledgehub 

Deploying primitive adapter needs three steps:- 

  - Build the docker image.
  - Push the docker image on Knowledgehub.
  - Deploy the container of the pushed docker image in the Knowledgehub kubernetes cluster.

## 1. Build and Push the Docker Image of Your Service

To illustrate this step we will use a sample docker image available at: [https://dockerhub.etransafe.eu/WP9/emc/tree/nikhita/clinical-pa/docker](https://dockerhub.etransafe.eu/WP9/emc/tree/nikhita/clinical-pa/docker)

```sh
$ sudo docker build -t dockerhub.etransafe.eu:5111/wp9/emc/clinicaltrials-pa:latest .
$ sudo docker push dockerhub.etransafe.eu:5111/wp9/emc/clinicaltrials-pa:latest
```
The registry simply stores the pushed image, but containers are not running there. The service will run on Knowledgehub cluster only after the deployment.

## 2. Update Knowledgehub Database Tables if You Need Them In Your Service
The first step is to forward database port to your local computer, e.g. for MySQL:
```sh
 kubectl -n kh port-forward services/mysql-database 33306:3306
 ```
This step will proxy the remote Knowledgehub database port 3306, to a local port on your computer, e.g. 33306. Secondly, make sure the shell in which you ran the aforementioned command kept open when you work with the database. Next, try connecting to the remote Knowledgehub database via the forwarded local port:
```sh
mysql -u root --port 33306 -p
```
Upon connection you can make changes to the database.

## 3. Deployment
During deployment, the service app in the container can use whatever port it needs to, provided the port is correctly mapped in the deployment manifest to the gateway route. As an example, consider inspecting the deployment manifest for clinical trials Primitive Adapter at: 

[https://dockerhub.etransafe.eu/WP9/emc/blob/master/clinical-pa/kubernetes/etransafe.clinicalpa.service.yaml]

You can use this as a template for your manifest. Please consider the information from System architecture & deployment PowerPoint, in particular, the naming conventions and the default namespace "kh". These must be followed when implementing the deployment manifest in order to allow the semantic service component to be registered by the KH registry later on. As soon as you have your manifest ready, you can deploy the service using the following command:

```sh
$ kubectl apply -f <name of your manifest file.yaml>
```
You will need the cluster config file for this, but if you have used the port forwarding command in Step 2, you already have it. After deployment the service will appear in the Rancher dashboard at:

[https://dev.kh.etransafe.eu:38443/p/c-gzkgs:p-nbr4c/workloads]

where you can inspect if it is running correctly, check the container logs, redeploy, or edit the deployment on the fly. 
