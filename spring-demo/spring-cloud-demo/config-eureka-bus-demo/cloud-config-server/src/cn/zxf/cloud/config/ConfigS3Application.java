package cn.zxf.cloud.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
@EnableDiscoveryClient
public class ConfigS3Application {

    public static void main( String[] args ) {
	new SpringApplicationBuilder( ConfigS3Application.class )//
        .profiles( "default", "s3" ) //
        .run( args );
    }

}
