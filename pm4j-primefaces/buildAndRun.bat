@echo off
call mvn clean package
call docker build -t com.hiraas.pm4j/pm4j-primefaces .
call docker rm -f pm4j-primefaces
call docker run -d -p 8080:8080 -p 4848:4848 --name pm4j-primefaces com.hiraas.pm4j/pm4j-primefaces