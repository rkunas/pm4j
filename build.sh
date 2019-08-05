#!/bin/sh
cd $TRAVIS_BUILD_DIR/pm4j-pm
mvn install emma:emma
