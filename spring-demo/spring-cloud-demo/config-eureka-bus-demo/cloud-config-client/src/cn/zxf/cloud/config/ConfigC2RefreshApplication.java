package cn.zxf.cloud.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConfigC2RefreshApplication {

    public static void main( String[] args ) {
	new SpringApplicationBuilder( ConfigC2RefreshApplication.class )//
	        .profiles( "default", "c2" )//
	        .run( args );
    }

}
