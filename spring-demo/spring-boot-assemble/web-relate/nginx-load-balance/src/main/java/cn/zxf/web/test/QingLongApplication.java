package cn.zxf.web.test;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

//9081
@SpringBootApplication
public class QingLongApplication {

    public static void main( String[] args ) {
        new SpringApplicationBuilder().profiles( "qing_long" )
                .sources( QingLongApplication.class )
                .run( args );
    }

}
