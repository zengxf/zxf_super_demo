package cn.zxf.swagger2_test.config;

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
                .apiInfo( apiInfo() ) //
                .select() //
                .apis( RequestHandlerSelectors.basePackage( "cn.zxf.swagger2_test" ) ) //
                .paths( PathSelectors.any() ) //
                .build();

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder() //
                .title( "Swagger2 测试" ) //
                .description( "测试 https://zengxf.github.io/zxf-blog" ) //
                .termsOfServiceUrl( "https://zengxf.github.io/zxf-blog" ) //
                .contact( new Contact( "zxf", "https://zengxf.github.io/zxf-blog", "fl_zxf@sina.cn" ) ) //
                .version( "1.0" ) //
                .build();

    }

}
