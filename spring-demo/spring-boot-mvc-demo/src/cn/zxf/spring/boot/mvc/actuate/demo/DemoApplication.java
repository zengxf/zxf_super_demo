package cn.zxf.spring.boot.mvc.actuate.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.endpoint.Endpoint;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication( exclude = { //
        DataSourceAutoConfiguration.class, //
        HibernateJpaAutoConfiguration.class //
} )
@RestController
@PropertySource( "classpath:/cn/zxf/spring/boot/mvc/actuate/demo/resources/application.properties" )
public class DemoApplication {
    @Autowired
    StatusService statusService;

    public static void main( String[] args ) {
	SpringApplication.run( DemoApplication.class, args );
    }

    @Bean
    public Endpoint<String> status() {
	Endpoint<String> status = new StatusEndPoint();
	return status;
    }

    @RequestMapping( "/change" )
    public String changeStatus( String status ) {
	statusService.setStatus( status );
	return "OK";
    }
}
