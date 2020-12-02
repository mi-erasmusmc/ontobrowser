##Local development using Docker
This is how you can use Docker to run Ontobrowser.

All commands below presume your present working directory is the docker folder

Start Ontobrowser and a mysql database
```bash
$ docker-compose up
```

The database is now running on localhost:3306 with username root and password root.
The application runs on localhost:8080

That was easy...

...First time round the deployment of the Ontobrowser in Wildfly will fail because the db has not yet been initialized.
Run the create_db.sql file either in workbench or from the commandline
```bash
$ docker cp ../db/db_create.sql ontobrowser_db:/
$ docker exec -it ontobrowser_db /bin/bash -c 'mysql -u root -proot </db_create.sql'
```

You are now good to go and docker-compose up will do the job :-)

To redeploy in the containerized Wildfly do a Maven clean package and replace the .war file in your running container with the newly created one.
This will automatically kickstart the whole thing.
```bash
$ mvn clean package
$ docker cp ../target/ontobrowser.war ontobrowser:/wildfly-14.0.1.Final/standalone/deployments/ROOT.war
```



##Deployment to AWS Test using Docker 
At present we only push an image of ontobrowser to ECR (Elastic Container Repository) and GMV handle the rest.
To do this you need to be have configured the ECR first.

First make sure sure you are building the latest version of your app, so build the war file and copy it to the docker folder.

```bash
$ mvn clean package
$ cp ../target/ontobrowser.war ./
```

Then build the image and push it to the AWS test env

```bash
$ docker build -t etransafe/test-app:version .
$ docker tag test-app:version 393732904747.dkr.ecr.eu-west-1.amazonaws.com/etransafe/test-app:version
$ docker push 393732904747.dkr.ecr.eu-west-1.amazonaws.com/etransafe/test-app:version
```

Contact GMV (Enric) to release the image

