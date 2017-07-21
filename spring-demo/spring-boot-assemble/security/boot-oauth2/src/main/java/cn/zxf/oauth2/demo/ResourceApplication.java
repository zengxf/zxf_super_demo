package cn.zxf.oauth2.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Data;

@SpringBootApplication
@RestController
@EnableResourceServer
public class ResourceApplication {

    public static void main( String[] args ) {
	new SpringApplicationBuilder( ResourceApplication.class ) //
	        .profiles( "resource" ) //
	        .run( args );
    }

    @RequestMapping( "/" )
    public Message home() {
	return new Message( "Hello World" );
    }

    @Data
    @AllArgsConstructor
    public static class Message {
	private String message;
    }

}
