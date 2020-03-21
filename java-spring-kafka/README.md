# Java Spring Kafka Guide

Docker를 이용한 Java Spring 기반의 Zookeeper, Kafka 설치 및 실행 Guide

## Module 환경 구성
- Java 11(OpenJDK 11)


## Docker 설치

### Mac 에 Docker 설치
    $ brew cask install docker

### Docker, Virtual machine 설치
    $ brew install docker docker-machine
    $ brew cask install virtualbox
    
- virtualbox install을 실패하면서 에러 메시지가 발생한다
- 이때 System Preferences -> Security & Privacy 메뉴에 접근해서 Allow 해주고 다시 brew cask install virtualbox를 실행해주면 설치가 완료된다

### Virtual machine 생성
    $ docker-machine create --driver virtualbox default

### Virtual machine 설정
- Docker 명령을 사용할 수 있게 설정한다

        $ docker-machine env default

## Zookeeper, Kafka 실행

### docker-compose.yml 작성

### Zookeeper, Kafka container 실행
    $ docker-compose up -d

### Zookeeper, Kafka container 중지
    $ docker-compose down

### Zookeeper container log 확인
    $ docker container logs local-zookeeper

### Kafka container log 확인
    $ docker container logs local-kafka

### Kafka container 접속
    $ docker exec -i -t local-kafka bash

## Kafka 실행 확인
- Docker에 설치한 동일한 버전의 Kafka 설치한다
 
### Kafka Binary file download
- https://kafka.apache.org/downloads

        $ sh bin/kafka-topics.sh --zookeeper localhost:2181 --list

### Kafka topic 생성 확인
    $ bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic tmp-topic
- Topic Name에 period (‘.’) or underscore (‘_’)는 피해서 작명한다

### Kafka consumer 실행(console 1)
    $ bin/kafka-console-consumer.sh --topic javainuse-topic --bootstrap-server localhost:9092 --from-beginning    

### Kafka producer 실행(console 2)
    $ bin/kafka-console-producer.sh --topic javainuse-topic --broker-list localhost:9092

### Kafka Message 전송
console 1에서 2로 메시지를 전송한다

## Reference
- https://codefresh.io/docs/docs/yaml-examples/examples/spring-boot-kafka-zookeeper/
- https://miiingo.tistory.com/196
- https://dc7303.github.io/docker/2019/11/24/dockerInstallForMac/
- https://brunch.co.kr/@springboot/322
- https://docs.docker.com/
- https://www.baeldung.com/spring-kafka
- https://yfkwon.tistory.com/26
- https://kok202.tistory.com/104