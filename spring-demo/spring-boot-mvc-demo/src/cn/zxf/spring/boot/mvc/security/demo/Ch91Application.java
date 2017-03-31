package cn.zxf.spring.boot.mvc.security.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource( "classpath:/cn/zxf/spring/boot/mvc/security/demo/resources/application.properties" )
public class Ch91Application {

    public static void main( String[] args ) {
	SpringApplication.run( Ch91Application.class, args );
    }
}
