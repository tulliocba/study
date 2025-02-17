package io.tulliocba.springbootresthibernate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(RequestHandlerSelectors.basePackage("io.tulliocba.springbootresthibernate.controller"))
                .paths(PathSelectors.regex("/.*"))
                .build()
                .apiInfo(apiEndpointsInfo());
    }

    private ApiInfo apiEndpointsInfo() {
        return new ApiInfoBuilder().title("Title teste")
                .description("Description teste")
                .license("Apache 2.0")
                .version("1.0.0")
                .build();
    }

}
