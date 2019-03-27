package cn.zxf.jpa_starter.test;

import java.io.IOException;
import java.net.URISyntaxException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaStarterApplication {

    public static void main( String[] args ) throws URISyntaxException, IOException {
        SpringApplication.run( JpaStarterApplication.class, args );
    }
    
}
