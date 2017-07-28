package cn.zxf.unit_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@EnableMongoAuditing
@SpringBootApplication
public class UnitTestApplication {

    public static void main( String[] args ) {
	SpringApplication.run( UnitTestApplication.class, args );
    }

}
