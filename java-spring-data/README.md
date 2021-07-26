# Java Spring Data Guide
Java Spring Data 기반 Guide

## Module 환경 구성
- Java 11(OpenJDK 11)
- Spring Data Redis
- Lettuce
- Embedded Redis(it.ozimov.embedded-redis)

## Swagger URL
http://localhost:9980/swagger-ui/index.html

## Redis Master Slave - Setup
Docker 실행

Redis Master Slave 실행

    docker-compose up master slave-a slave-b redis-commander

## Embedded Redis usage example

    127.0.0.1:6379> hget userAuthentication:test1 status
    "done"


### Reference
- https://jojoldu.tistory.com/297
