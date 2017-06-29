package cn.zxf.cloud.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
@EnableDiscoveryClient
public class ConfigServerApplication1 {

    public static void main( String[] args ) {
	new SpringApplicationBuilder( ConfigServerApplication1.class )//
	        .profiles( "default", "s1" ) //
	        .run( args );
    }

}
