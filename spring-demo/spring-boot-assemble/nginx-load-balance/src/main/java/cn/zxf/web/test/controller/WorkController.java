package cn.zxf.web.test.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/work" )
public class WorkController {

    @Value( "${app.id}" )
    private String appId;

    @GetMapping( "hello" )
    public String hello() {
        return "hello " + appId;
    }

}
