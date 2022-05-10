FROM openjdk:8u191-jre-alpine3.8

RUN apk add curl jq

#workspace
WORKDIR /usr/share/udemy

#ADD .jar under target from host
#into this image
ADD target/selenium-docker.jar 			selenium-docker.jar
ADD target/selenium-docker-tests.jar 	selenium-docker-tests.jar
ADD target/libs							libs

#In case of any dependencies like CSV, JSON, Property, Excel
# Please add that as well


# ADD suite files
ADD testng.xml 							book-flight-module.xml
ADD search-module.xml					search-module.xml

#Add helthCheck.sh script
ADD helthCheck.sh                       healthCheck.sh
RUN wget https://s3.amazonaws.com/selenium-docker/healthcheck/healthcheck.sh


ENTRYPOINT sh healthCheck.sh