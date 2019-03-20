package cn.zxf.jdbc_transaction.test;

import java.io.IOException;
import java.net.URISyntaxException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JdbcTransactionApplication {

    public static void main( String[] args ) throws URISyntaxException, IOException {
        SpringApplication.run( JdbcTransactionApplication.class, args );
    }
    
}
