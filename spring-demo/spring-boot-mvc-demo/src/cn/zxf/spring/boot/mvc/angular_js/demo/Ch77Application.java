package cn.zxf.spring.boot.mvc.angular_js.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication( exclude = SecurityAutoConfiguration.class )
@PropertySource( "classpath:/cn/zxf/spring/boot/mvc/angular_js/demo/resources/application.properties" )
public class Ch77Application {

    @RequestMapping( value = "/search", produces = { MediaType.APPLICATION_JSON_VALUE } )
    public Person search( String personName ) {
	return new Person( personName, 32, "hefei" );
    }

    public static void main( String[] args ) {
	SpringApplication.run( Ch77Application.class, args );
    }
}
