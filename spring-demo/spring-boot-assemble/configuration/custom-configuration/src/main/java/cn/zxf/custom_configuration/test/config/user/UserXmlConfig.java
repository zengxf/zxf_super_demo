package cn.zxf.custom_configuration.test.config.user;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource( locations = "classpath:my/user.xml" )
public class UserXmlConfig {

}
