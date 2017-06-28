package cn.zxf.cloud.eureka;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.test.context.ActiveProfiles;

@SpringBootApplication
@EnableEurekaServer
@ActiveProfiles( "peer2" )
public class EurekaPeer2Application {

    public static void main( String[] args ) {
	new SpringApplicationBuilder() //
	        .sources( EurekaPeer2Application.class ) //
	        .profiles( "peer2" ) //
	        .run( args );
    }

}
