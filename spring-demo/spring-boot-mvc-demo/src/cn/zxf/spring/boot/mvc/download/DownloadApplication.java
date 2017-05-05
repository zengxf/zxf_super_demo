package cn.zxf.spring.boot.mvc.download;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication( exclude = { DataSourceAutoConfiguration.class, //
        DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class } )
@PropertySource( "classpath:/cn/zxf/spring/boot/mvc/download/resources/application.properties" )
public class DownloadApplication {

    public static void main( String[] args ) {
	try {
	    SpringApplication.run( DownloadApplication.class, args );
	} catch ( Exception e ) {
	    e.printStackTrace();
	}
    }
}
