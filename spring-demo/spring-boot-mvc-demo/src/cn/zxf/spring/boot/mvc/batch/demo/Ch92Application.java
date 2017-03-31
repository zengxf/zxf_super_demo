package cn.zxf.spring.boot.mvc.batch.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication( exclude = SecurityAutoConfiguration.class )
@PropertySource( "classpath:/cn/zxf/spring/boot/mvc/batch/demo/resources/application.properties" )
public class Ch92Application {

    public static void main( String[] args ) {
	SpringApplication.run( Ch92Application.class, args );
    }
}
