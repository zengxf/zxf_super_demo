package cn.zxf.session_share.test;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SessionShareTestApplication9081 {

    public static void main( String[] args ) {
        new SpringApplicationBuilder().profiles( "port-9081" )
                .sources( SessionShareTestApplication9081.class )
                .build()
                .run( args );
    }

}
