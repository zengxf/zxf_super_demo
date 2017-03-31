package cn.zxf.spring.boot.mvc.junit.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@PropertySource( "classpath:/cn/zxf/spring/boot/mvc/junit/demo/resources/application.properties" )
@SpringBootApplication
public class Ch104Application {

    public static void main( String[] args ) {
	SpringApplication.run( Ch104Application.class, args );
    }
}
