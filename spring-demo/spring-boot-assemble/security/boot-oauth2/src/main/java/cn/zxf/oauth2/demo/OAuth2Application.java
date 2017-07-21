package cn.zxf.oauth2.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * 简单的 OAuth2 示例
 * 
 * <p>
 * Created by zxf on 2017-07-21
 */
@SpringBootApplication
@EnableAuthorizationServer
public class OAuth2Application {

    public static void main( String[] args ) {
	new SpringApplicationBuilder( OAuth2Application.class ) //
	        .profiles( "oauth2" ) //
	        .run( args );
    }

}
