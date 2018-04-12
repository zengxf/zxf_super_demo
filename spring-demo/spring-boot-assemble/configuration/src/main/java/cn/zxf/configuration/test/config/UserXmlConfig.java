package cn.zxf.configuration.test.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource( locations = "classpath:user.xml" )
public class UserXmlConfig {

}
