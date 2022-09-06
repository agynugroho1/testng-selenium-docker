FROM openjdk:8u191-jre-alpine3.8

RUN apk add curl jq

#WORK_SPACE
WORKDIR /usr/share/udemy

# ADD .jar under target from host
# into this image
ADD target/selenium-docker.jar          selenium-docker.jar
ADD target/selenium-docker-tests.jar    selenium-docker-test.jar
ADD target/libs                         libs

# ADD Suite files
ADD book-flight.xml                     book-flight.xml
ADD search-module.xml                   search-module.xml


ADD healthcheck.sh                      healthcheck.sh

# BROWSER
# HUB_HOST
# MODULE

ENTRYPOINT sh healthcheck.sh