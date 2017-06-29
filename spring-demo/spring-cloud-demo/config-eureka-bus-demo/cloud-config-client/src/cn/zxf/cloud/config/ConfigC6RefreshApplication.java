package cn.zxf.cloud.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConfigC6RefreshApplication {

    public static void main( String[] args ) {
	new SpringApplicationBuilder( ConfigC6RefreshApplication.class )//
	        .profiles( "default", "c6" )//
	        .run( args );
    }

}
