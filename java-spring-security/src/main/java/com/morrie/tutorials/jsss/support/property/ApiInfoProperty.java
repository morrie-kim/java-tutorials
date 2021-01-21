package com.morrie.tutorials.jsss.support.property;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.validation.Valid;

/**
 * Created by morrie kim on 2021/01/20.
 */
@Configuration
@ConfigurationProperties("application.info")
@Getter
@Setter
public class ApiInfoProperty {

    private String name;
    private String basePackage;

    @Valid
    private Version version = new Version();

    @Getter
    @Setter
    public static class Version {
        private String major;
        private String full;
    }


}
