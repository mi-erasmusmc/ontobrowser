##Local development using Docker
This is how you can easily use Docker to run Ontobrowser.

Required:\
Docker - https://docs.docker.com/get-docker/\
Maven - https://maven.apache.org/download.cgi\
Make - https://www.gnu.org/software/make/ Note: it is pre installed with Mac command line tools enter ```make -v``` to check

Run these commands from the project root where the Makefile is located (if you want to see what the commands do, look there also)
To start Ontobrowser and a mysql database
```make up```

First time round this will take a couple of minutes to download everything you need.

The database is now running on localhost:3306 with username root and password root.
The application runs on localhost:8080

That was easy ... first time round the deployment of the Ontobrowser in Wildfly will fail because the db has not yet been created.
use ```make db-init```. The db is now persisted in a volume and until you remove it will stay there. The app will restart automagically.

You are good to go ```make up``` wil do the job each time you need to start.

To redeploy the changed code into the containerized Wildfly you need to do a Maven clean package and replace the .war file in your running container with the newly created one.
This will automatically kickstart the whole thing. Use this command:
```make build-deploy```

To stop your containers ```make down```

For more details about what is happening check the Makefile and the docker-compose.yml.

##Deployment to AWS Test using Docker 
At present we only push an image of ontobrowser to ECR (Elastic Container Repository) and GMV handle the rest.
To do this you need to be have configured in the ECR first.

```make build-push-image version="<version number>"```

This builds the current version of your app, copies it to the docker folder.
it then builds the image and pushes it to the AWS test env.

Contact GMV (Enric) to release the image.
