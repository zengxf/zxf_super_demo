package cn.zxf.redis.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SessionRedisApplicationSer1 {

    public static void main( String[] args ) {
	new SpringApplicationBuilder( SessionRedisApplicationSer1.class ) //
	        .profiles( "ser1" ) //
	        .run( args );
    }

}
