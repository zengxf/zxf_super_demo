package cn.zxf.web.test;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

// 9082
@SpringBootApplication
public class BaiHuApplication {

    public static void main( String[] args ) {
        new SpringApplicationBuilder().profiles( "bai_hu" )
                .sources( BaiHuApplication.class )
                .run( args );
    }

}
