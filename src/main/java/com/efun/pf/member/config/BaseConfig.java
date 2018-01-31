package com.efun.pf.member.config;

import exception.EfunExceptionHandler;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Acel
 * @since 2017/12/25
 */
@EntityScan("com.efun.pf.member.entity")
@EnableJpaAuditing
@Configuration
@EnableSwagger2
public class BaseConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.efun.pf.member.web"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Efun平台工程 会员服务API")
                .contact("肖湘")
                .build();
    }

    @Bean
    public EfunExceptionHandler efunExceptionHandler() {
        return new EfunExceptionHandler();
    }
}
