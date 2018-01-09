TAG=$(shell date -I -u)
IMAGE=jenkinsci/workflow-demo
DOCKER_RUN=docker run --rm -p 127.0.0.1:2222:2222 -p 127.0.0.1:8080:8080 -p 127.0.0.1:8081:8081 -p 127.0.0.1:9418:9418 -ti -v m2repo:/m2repo

copy-plugins:
	if [ \! -f target/test-classes/test-dependencies/index -o \
	     pom.xml -nt target/test-classes/test-dependencies/index ]; then \
	    mvn clean validate hpi:resolve-test-dependencies; fi
	# TODO would be more efficient to move Dockerfile and all it references into a subdirectory, or use .dockerignore
	rm -rf plugins
	mkdir plugins
	cp -v target/test-classes/test-dependencies/*.hpi plugins

# http://stackoverflow.com/q/23544282/12916 unclear how best to ensure that the jenkins user can write to this volume
volume:
	docker volume create --name=m2repo
	docker run --rm -v m2repo:/m2repo ubuntu chmod -v a+rw /m2repo

build: copy-plugins volume
	docker build -t $(IMAGE):$(TAG) .

run: build
	$(DOCKER_RUN) $(IMAGE):$(TAG)

push:
	docker push $(IMAGE):$(TAG)
	echo "consider also: make push-latest"

push-latest: push
	docker tag $(IMAGE):$(TAG) $(IMAGE):latest
	docker push $(IMAGE):latest
