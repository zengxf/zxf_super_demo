package cn.zxf.cloud.eureka.peer1;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaPeer1Application {

    public static void main( String[] args ) {
	new SpringApplicationBuilder() //
	        .sources( EurekaPeer1Application.class ) //
	        .profiles( "peer1" ) //
	        .run( args );
    }

}
