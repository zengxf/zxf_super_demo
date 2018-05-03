package cn.zxf.custom_configuration.test.config.position;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Data;

@Configuration
@PropertySource( value = "classpath:my/position.yml", encoding = "UTF-8" )
@ConfigurationProperties( prefix = "position" )
@Data
public class PositionConfig {

    @Value( "${name}" )
    private String name;
    @Value( "${address}" )
    private String address;

}
