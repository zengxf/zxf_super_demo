package cn.zxf.ds_druid.test;

import java.io.IOException;
import java.net.URISyntaxException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DsDruidApplication {

    public static void main( String[] args ) throws URISyntaxException, IOException {
        SpringApplication.run( DsDruidApplication.class, args );
    }

}
