package com.morrie.tutorials.jsdms.user.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.morrie.tutorials.jsdms.support.serializer.CustomLocalDateTimeDeserializer;
import com.morrie.tutorials.jsdms.support.serializer.CustomLocalDateTimeSerializer;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by morrie kim on 2020/03/09.
 */
@Getter
@Document(collection = "userPoint")
public class UserPoint implements Serializable {
    @Id
    private String id;
    private Long amount;

    @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
    @JsonDeserialize(using = CustomLocalDateTimeDeserializer.class)
    protected LocalDateTime refreshTime;

    @Builder
    public UserPoint(String id, Long amount, LocalDateTime refreshTime) {
        this.id = id;
        this.amount = amount;
        this.refreshTime = refreshTime;
    }

}
