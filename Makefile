up:
	cd docker; docker-compose up

down:
	cd docker; docker-compose down

creat-db:
	docker cp ./db/db_create.sql ontobrowser_db:/
	docker exec -it ontobrowser_db /bin/bash -c 'mysql -u root -proot </db_create.sql'

db-init: creat-db deploy

build-push-image:
	build
	cp ./target/ontobrowser.war ./docker
	@echo "Building docker image"
	docker build -t etransafe/ontobrowser:$(version) .
	docker tag ontobrowser:version 393732904747.dkr.ecr.eu-west-1.amazonaws.com/etransafe/ontobrowser:$(version)
	@echo "Pushing to AWS ECR"
	docker push 393732904747.dkr.ecr.eu-west-1.amazonaws.com/etransafe/ontobrowser:$(version)

build-deploy: build deploy

build:
	@echo "Packaging ontobroser into war file"
	mvn clean package

deploy:
	@echo "Copying war file into container"
	cd docker; docker cp ../target/ontobrowser.war ontobrowser:/wildfly-14.0.1.Final/standalone/deployments/ROOT.war
