package cn.zxf.redis.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SessionRedisApplicationSer2 {

    public static void main( String[] args ) {
	new SpringApplicationBuilder( SessionRedisApplicationSer2.class ) //
	        .profiles( "ser2" ) //
	        .run( args );
    }

}
