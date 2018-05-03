package cn.zxf.custom_configuration.test.config.position;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Data;

@SuppressWarnings( "deprecation" )
@Configuration
@PropertySource( value = "classpath:my/position.yml", factory = YamlPropertySourceFactory.class )
@ConfigurationProperties( prefix = "position" )
@Data
@Deprecated // 并没有什么卵用
public class AutoPositionConfig {

    // @Value( "${name}" )
    private String name;
    // @Value( "${address}" )
    private String address;

}
