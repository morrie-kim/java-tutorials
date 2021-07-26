package com.morrie.tutorials.jsds.user.domain;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

/**
 * Created by morrie kim on 2021/07/26.
 */
@Getter
@RedisHash("userpoint")
public class UserAuthentication implements Serializable {
    @Id
    private String id;
    private String status;

    @Builder
    public UserAuthentication (String id, String status) {
        this.id = id;
        this.status = status;
    }
}
