package com.morrie.tutorials.jsdms.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by morrie kim on 2020/03/24.
 */
@Getter
@Setter
@ToString
public class UserPointDto implements Serializable {

    private static final long serialVersionUID = -4483264099865152693L;

    @JsonProperty("id")
    private String userId;

    @JsonProperty("amount")
    private Long amount;

    public static class RequestUserPointDto extends UserPointDto {

    }
}
