package cn.zxf.oauth2.demo;

import java.security.Principal;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 稍微复杂的 OAuth2 示例
 * 
 * <p>
 * Created by zxf on 2017-07-21
 */
@SpringBootApplication
@RestController
@EnableAuthorizationServer
@EnableResourceServer
public class AuthApplication {

    public static void main( String[] args ) {
	new SpringApplicationBuilder( AuthApplication.class ) //
	        .profiles( "oauth2" ) //
	        .run( args );
    }

    @RequestMapping( "/user" )
    public Principal user( Principal user ) {
	return user;
    }

}
