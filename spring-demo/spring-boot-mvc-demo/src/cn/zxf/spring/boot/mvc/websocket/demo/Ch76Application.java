package cn.zxf.spring.boot.mvc.websocket.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource( "classpath:/cn/zxf/spring/boot/mvc/websocket/demo/resources/application.properties" )
public class Ch76Application {

    public static void main( String[] args ) {
	SpringApplication.run( Ch76Application.class, args );
    }
}
