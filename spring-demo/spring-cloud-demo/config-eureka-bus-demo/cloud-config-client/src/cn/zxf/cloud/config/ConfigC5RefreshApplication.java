package cn.zxf.cloud.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConfigC5RefreshApplication {

    public static void main( String[] args ) {
	new SpringApplicationBuilder( ConfigC5RefreshApplication.class )//
	        .profiles( "default", "c5" )//
	        .run( args );
    }

}
