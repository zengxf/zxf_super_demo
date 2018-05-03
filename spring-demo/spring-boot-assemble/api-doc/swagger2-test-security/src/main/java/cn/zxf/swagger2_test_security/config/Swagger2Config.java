package cn.zxf.swagger2_test_security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket createRestApi() {
        return new Docket( DocumentationType.SWAGGER_2 ) //
                .groupName( "position-职位" )
                .apiInfo( apiInfo() )
                .select()
                .apis( RequestHandlerSelectors.basePackage( "cn.zxf.swagger2_test_security.module.position" ) ) //
                .paths( PathSelectors.any() ) //
                .build();
    }

    @Bean
    public Docket createOtherApi() {
        return new Docket( DocumentationType.SWAGGER_2 ) //
                .host( "core.api.hunterplus.net" )
                .groupName( "other-未分类" )
                .apiInfo( apiInfo() )
                .select()
                .apis( RequestHandlerSelectors.basePackage( "cn.zxf.swagger2_test_security" ) ) //
                .paths( PathSelectors.any() ) //
                .build();
    }

    @Bean
    public Docket customDocket2() {
        return new Docket( DocumentationType.SWAGGER_2 ) //
                .groupName( "user-用户" )
                .apiInfo( apiInfo() )
                .select()
                .paths( PathSelectors.ant( "/api/user/**" ) )
                .build();
    }

    ApiInfo apiInfo() {
        return new ApiInfoBuilder() //
                .title( "Core API" )
                .description( "core api" )
                .termsOfServiceUrl( "http://gitlab.hunterplus.net/liemeng/core" )
                .contact( new Contact( "zxf", "http://gitlab.hunterplus.net/liemeng/core", "2720xxx@qq.com" ) )
                .version( "2.0" )
                .build();
    }

}
