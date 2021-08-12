package com.morrie.tutorials.jsdms.support.config;

import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.*;
import com.mongodb.ServerAddress;
import com.mongodb.WriteConcern;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by morrie kim on 2021/08/10.
 */
@Configuration
@EnableMongoRepositories
@Slf4j
public class MongoRepositoryConfig extends AbstractMongoClientConfiguration {
    @Value("${spring.mongodb.host}")
    private String host;

    @Value("${spring.mongodb.port}")
    private String port;

    @Value("${spring.mongodb.database}")
    private String database;

    @Value("${spring.mongodb.uri}")
    private String uri;

    @Value("${spring.mongodb.username}")
    private String username;

    @Value("${spring.mongodb.password}")
    private String password;

    protected ServerAddress[] getServerAddresses() {
        Iterable<String> urlSplit = getReplicaSetsIterable();
        //Logger.("connecting to mongo url: " + urlSplit);
        List<ServerAddress> replicaSetList = new ArrayList<ServerAddress>();
        Iterator<String> urlIter = urlSplit.iterator();
        while(urlIter.hasNext()) {
            String serverAddress = urlIter.next();
            //logger.debug("replica set address: " + serverAddress);
            StringTokenizer hostTokenizer = new StringTokenizer(serverAddress, ":");
            String host = hostTokenizer.nextToken();
            Integer port = Integer.valueOf(hostTokenizer.nextToken());
            ServerAddress address = new ServerAddress(host, port.intValue());
            replicaSetList.add(address);
        }

        ServerAddress[] serverAddresses = new ServerAddress[replicaSetList.size()];
        return replicaSetList.toArray(serverAddresses);

    }

    private Iterable<String> getReplicaSetsIterable() {
        return Splitter.on(",").trimResults().omitEmptyStrings().split(uri);
    }

    protected boolean isReplicaSet() {
        Iterable<String> urlSplit = getReplicaSetsIterable();
        return Iterables.size(urlSplit) > 1;
    }

    @Bean(name={"productMongoTemplate"})
    @Override
    public MongoTemplate mongoTemplate() throws Exception {
        MongoTemplate mongoTemplate = super.mongoTemplate();
        if(isReplicaSet()) {
            // this will wait for at least 2 servers for the write operation before throwing exception
            mongoTemplate.setWriteConcern(WriteConcern.ACKNOWLEDGED);
        }
        else {
            // required by spring-data to re-throw server exception on the client end
            mongoTemplate.setWriteConcern(WriteConcern.ACKNOWLEDGED);
        }
        return mongoTemplate;
    }

    @Override
    public String getDatabaseName() {
        return database;
    }

    @Override
    public MongoClient mongoClient() {
        //ConnectionString connectionString = new ConnectionString("mongodb+srv://avacadodev2050:jTsjk6djwg6eEf8D@cluster0.8pnwi.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
        ConnectionString connectionString = new ConnectionString(uri);
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();

        return MongoClients.create(mongoClientSettings);
    }
}
