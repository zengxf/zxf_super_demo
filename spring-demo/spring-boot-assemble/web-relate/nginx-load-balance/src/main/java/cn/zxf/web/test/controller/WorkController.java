package cn.zxf.web.test.controller;

import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/work" )
public class WorkController {

    @Value( "${app.id}" )
    private String appId;
    @Value( "${server.port}" )
    private String serverPort;

    @PostConstruct
    public void init() {
        System.out.println();
        System.out.println( appId + "\t" + serverPort );
        System.out.println();
    }

    @GetMapping( "hello" )
    public String hello() {
        return "hello " + appId;
    }

    @GetMapping( "hello-sleep" )
    public String helloSleep() {
        int r = new Random().nextInt( 2 );
        int millis = 1010 + r * 1000;

        System.out.println( appId + "\t" + serverPort + "\t" + millis );
        this.sleep( millis );
        System.out.println( appId + "\t" + serverPort + "\t" + millis + "\t OK!" );

        return "hello " + appId + "  " + millis;
    }

    private void sleep( long millis ) {
        try {
            Thread.sleep( millis );
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }
    }

}
