package cn.zxf.configuration.test.config;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Data;

@Configuration
@PropertySource( "classpath:user.properties" )
@ConfigurationProperties( prefix = "user" )
@Data
public class UserConfig {

    private String  name;
    @NotEmpty // JSR-303 & 在 starter-web 下可用
    private String  nick;
    private Integer age;

}
