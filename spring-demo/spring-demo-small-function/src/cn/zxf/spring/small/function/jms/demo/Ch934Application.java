package cn.zxf.spring.small.function.jms.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
@PropertySource( "classpath:/cn/zxf/spring/small/function/jms/demo/resources/application.properties" )
public class Ch934Application implements CommandLineRunner { // 1

    @Autowired
    JmsTemplate jmsTemplate; // 2

    public static void main( String[] args ) {
	new SpringApplicationBuilder( Ch934Application.class ) //
	        .web( false ) //
	        .run( args );
    }

    @Override
    public void run( String... args ) throws Exception {
	jmsTemplate.send( "my-destination", new Msg() ); // 3

    }
}
