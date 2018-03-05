package cn.test.api;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ServerStart {

    public static void main( String[] args ) throws Exception {
        new SpringApplicationBuilder( ServerStart.class ) //
                .profiles( "test" ) //
                .run( args );

        System.out.println( "Start DubboTestServer Done ..." );
    }

}
