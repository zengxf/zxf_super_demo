package cn.zxf.custom_configuration.test.config.user;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Data;

@Configuration
@PropertySource( value = "classpath:my/user.properties", encoding = "UTF-8" )
@ConfigurationProperties( prefix = "user" )
@Data
public class UserConfig {

    private String  name;
    @NotEmpty // JSR-303 & 在 starter-web 下可用
    private String  nick;
    private Integer age;

}
