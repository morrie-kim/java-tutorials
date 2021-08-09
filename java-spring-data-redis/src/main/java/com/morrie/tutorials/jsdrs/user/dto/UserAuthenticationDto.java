package com.morrie.tutorials.jsdrs.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by morrie kim on 2021/07/26.
 */
@Getter
@Setter
@ToString
public class UserAuthenticationDto implements Serializable {

    private static final long serialVersionUID = -12878836888710878L;

    @JsonProperty("id")
    private String userId;

    @JsonProperty("status")
    private String status;

    public static class RequestUserAuthenticationDto extends UserAuthenticationDto {

    }
}