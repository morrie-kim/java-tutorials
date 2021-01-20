package com.morrie.tutorials.jsds.support.config;

import com.morrie.tutorials.jsds.support.property.ApiInfoProperty;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.time.LocalDate;

/**
 * Created by morrie kim on 2021/01/14.
 */
@Configuration
@EnableOpenApi
public class SwaggerConfig {

    private ApiInfoProperty apiInfoProperty;

    @Autowired
    public SwaggerConfig(ApiInfoProperty apiInfoProperty) {
        this.apiInfoProperty = apiInfoProperty;
    }

    @Bean
    public Docket SwaggerApi() {
        String appTitle = apiInfoProperty.getName();
        String appVersion = apiInfoProperty.getVersion().getFull();
        String appDescription = String.format("%s Documentation %s", appTitle, appVersion);
        String appBasePackage = apiInfoProperty.getBasePackage();

        return new Docket(DocumentationType.OAS_30)
                .groupName(appTitle)
                .select()
                .apis(RequestHandlerSelectors.basePackage(appBasePackage))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(
                        new ApiInfoBuilder()
                            .version(appVersion)
                            .title(appTitle)
                            .description(appDescription)
                            .build()
                )
                .pathMapping("/")
                .directModelSubstitute(LocalDate.class, String.class)
                .genericModelSubstitutes(ResponseEntity.class)
                .useDefaultResponseMessages(true)
                .enableUrlTemplating(false);

    }
}
