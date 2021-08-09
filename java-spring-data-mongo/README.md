# Java Spring Data Mongo Guide

## Module 환경 구성
- Java 11(OpenJDK 11)
- Spring Data Mongo
- Embedded Mongo

## Swagger URL
http://localhost:9980/swagger-ui/index.html

## Start Docker's services(All)
    docker-compose up -d

## MongoDB
Local's MongoDB Start

    brew services start mongodb/brew/mongodb-community

Docker's MongoDB Start

    docker-compose up mongo1 mongo2 mongo3
    docker ps -a
    docker exec -u 0 -it 51 mongo

## Reference
- https://smoh.tistory.com/419
