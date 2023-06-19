[![Build Status](https://travis-ci.com/claudioaltamura/spring-boot-data-mongodb.svg?branch=main)](https://travis-ci.com/github/claudioaltamura/spring-boot-data-mongodb)

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

# spring-boot-data-mongodb
Spring Boot Data MongoDB example

## Docker

    cd docker
    docker-compose up -d

## App

    ./gradlew bootRun

## MongoDB 

connection string 

    mongodb://root:admin@localhost:27017/

## examples

find all
   
      curl http://localhost:8080/product_materials/

get one
    
     curl http://localhost:8080/product_materials/materialNumber/ABN123

