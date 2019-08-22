#!/bin/sh
mvn clean package && docker build -t com.hiraas.pm4j/pm4j-primefaces .
docker rm -f pm4j-primefaces || true && docker run -d -p 8080:8080 -p 4848:4848 --name pm4j-primefaces com.hiraas.pm4j/pm4j-primefaces