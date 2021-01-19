package com.morrie.tutorials.jsds.user.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.morrie.tutorials.jsds.support.serializer.CustomLocalDateTimeDeserializer;
import com.morrie.tutorials.jsds.support.serializer.CustomLocalDateTimeSerializer;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by morrie kim on 2020/03/09.
 */
@Getter
@RedisHash("userpoint")
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

    public void refresh(long amount, LocalDateTime refreshTime){
        if(refreshTime.isAfter(this.refreshTime)){
            // 저장된 데이터보다 최신 데이터일 경우
            this.amount = amount;
            this.refreshTime = refreshTime;
        }
    }
}
