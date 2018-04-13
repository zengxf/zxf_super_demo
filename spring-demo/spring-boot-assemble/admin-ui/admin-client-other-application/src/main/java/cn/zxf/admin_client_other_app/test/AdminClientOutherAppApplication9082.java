package cn.zxf.admin_client_other_app.test;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class AdminClientOutherAppApplication9082 {

    public static void main( String[] args ) {
        new SpringApplicationBuilder().profiles( "port-9082" )
                .sources( AdminClientOutherAppApplication9082.class )
                .build()
                .run( args );
    }

}
