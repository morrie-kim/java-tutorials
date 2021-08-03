# Java Spring Data Guide
Java Spring Data 기반 Guide

## Module 환경 구성
- Java 11(OpenJDK 11)
- Spring Data Redis
- Lettuce
- Embedded Redis(it.ozimov.embedded-redis)

## Swagger URL
http://localhost:9980/swagger-ui/index.html

## Redis 
### Master Slave - Setup
Redis Master Slave 실행(docker-compose)
    
    docker-compose up master slave-a slave-b redis-commander

### Embedded Redis
Usage Example

    127.0.0.1:6379> hget userAuthentication:test1 status
    "done"

## MongoDB
Local's MongoDB Start

    brew services start mongodb/brew/mongodb-community

Docker's MongoDB Start

    docker-compose up -d
    
    docker ps -a
    
    docker exec -u 0 -it 51 mongo

## Reference
- https://jojoldu.tistory.com/297
- https://smoh.tistory.com/419
