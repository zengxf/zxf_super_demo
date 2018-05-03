package cn.zxf.custom_configuration.test.config.random;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Data;

@Configuration
@PropertySource( "classpath:my/random.properties" )
@ConfigurationProperties( prefix = "rand" )
@Data
public class RandomConfig {

    private String  nestContent;
    private String  randStr;
    private Integer randInt;
    private Long randLong;
    private Integer randInt10;
    private Integer randInt10_20;

}
