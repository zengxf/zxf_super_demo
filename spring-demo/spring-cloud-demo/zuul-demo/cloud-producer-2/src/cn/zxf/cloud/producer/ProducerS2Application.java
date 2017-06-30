package cn.zxf.cloud.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProducerS2Application {

    public static void main( String[] args ) {
	SpringApplication.run( ProducerS2Application.class, args );
    }

}
