package cn.zxf.web.test;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class BaiHuApplication2 {

    public static void main( String[] args ) {
        new SpringApplicationBuilder().profiles( "bai_hu" )
                .sources( BaiHuApplication2.class )
                .run( args );
    }

}
