package cn.test.api.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DesConfig {

    @Value( "${server.desc}" )
    private String desc;

    @PostConstruct
    public void init() {
        System.out.println( "===============" );
        System.out.println( desc );
        System.out.println( "===============" );
    }

}
