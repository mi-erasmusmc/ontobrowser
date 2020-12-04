up:
	cd docker; docker-compose up

down:
	cd docker; docker-compose down

create-db:
	docker cp ./db/db_create.sql ontobrowser_db:/
	docker exec -it ontobrowser_db /bin/bash -c 'mysql -u root -proot </db_create.sql'

db-init: create-db deploy

build-push-image: build push-image

push-image:
	cp ./target/ontobrowser.war ./docker
	@echo "Building docker image"
	cd docker; \
	docker build -t etransafe/ontobrowser:$(version) .; \
	docker tag etransafe/ontobrowser:$(version) 393732904747.dkr.ecr.eu-west-1.amazonaws.com/etransafe/ontobrowser:$(version); \
	@echo "Pushing to AWS ECR"; \
	docker push 393732904747.dkr.ecr.eu-west-1.amazonaws.com/etransafe/ontobrowser:$(version); \

build-deploy: build deploy

build:
	@echo "Packaging ontobroser into war file"
	mvn clean package
	cp ./target/ontobrowser.war ./docker


deploy:
	@echo "Copying war file into container"
	cd docker; docker cp ../target/ontobrowser.war ontobrowser:/wildfly-14.0.1.Final/standalone/deployments/ROOT.war
