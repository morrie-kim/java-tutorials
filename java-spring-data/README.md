# Java Spring Data Guide
Java Spring Data 기반 Guide

## Module 환경 구성
- Java 11(OpenJDK 11)
- Spring Data JPA
- MySQL
- H2

## Swagger URL
http://localhost:9980/swagger-ui/index.html

## Start Docker's services(All)
    docker-compose up -d

## MySQL 
### Master Slave - Setup
Redis Master Slave 실행(docker-compose)
    
    docker-compose up master slave-a slave-b redis-commander

## Reference
