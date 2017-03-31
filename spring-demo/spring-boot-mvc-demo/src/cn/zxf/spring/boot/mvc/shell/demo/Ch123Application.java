package cn.zxf.spring.boot.mvc.shell.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication( exclude = { //
        DataSourceAutoConfiguration.class, //
        HibernateJpaAutoConfiguration.class //
} )
@PropertySource( "classpath:/cn/zxf/spring/boot/mvc/shell/demo/resources/application.properties" )
public class Ch123Application {

    public static void main( String[] args ) {
	new SpringApplicationBuilder( Ch123Application.class )//
	        .web( false )//
	        .run( args );
    }
}
