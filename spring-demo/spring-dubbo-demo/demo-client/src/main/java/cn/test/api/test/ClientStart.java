package cn.test.api.test;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class ClientStart {

    /**
     * 测试用：{@link TestSay}
     */
    public static void main( String[] args ) throws Exception {

        new SpringApplicationBuilder( ClientStart.class ).sources( ClientStart.class ).run( args );
        System.out.println( "Start DubboTestClient Done ..." );

    }

}
