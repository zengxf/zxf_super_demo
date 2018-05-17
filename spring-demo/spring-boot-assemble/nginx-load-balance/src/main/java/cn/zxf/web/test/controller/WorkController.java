package cn.zxf.web.test.controller;

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

}
