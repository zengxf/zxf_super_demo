package cn.zxf.cloud.eureka;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaPeer3Application {

    public static void main( String[] args ) {
	new SpringApplicationBuilder() //
	        .sources( EurekaPeer3Application.class ) //
	        .profiles( "peer3" ) //
	        .run( args );
    }

}
