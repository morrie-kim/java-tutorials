# Java Spring Data Redis Guide

## Module 환경 구성
- Java 11(OpenJDK 11)
- Spring Data Redis
- Lettuce
- Embedded Redis(it.ozimov.embedded-redis)
- Redis Replica Set Configuration

## Swagger URL
http://localhost:9980/swagger-ui/index.html

## Start Docker's services(All)
    docker-compose up -d

## Redis 
### Master Slave - Setup
Redis Master Slave 실행(docker-compose)
    
    docker-compose up master slave-a slave-b redis-commander

### Embedded Redis
Usage Example

    127.0.0.1:6379> hget userAuthentication:test1 status
    "done"

## Reference
- https://jojoldu.tistory.com/297
