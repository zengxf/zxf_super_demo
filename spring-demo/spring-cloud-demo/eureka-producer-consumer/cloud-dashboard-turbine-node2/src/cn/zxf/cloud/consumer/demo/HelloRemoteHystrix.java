package cn.zxf.cloud.consumer.demo;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class HelloRemoteHystrix implements HelloRemote {

    @Override
    public String hello( @RequestParam( value = "name" ) String name ) {
	return "hystrix - fuck - 1 - " + name;
    }

    @Override
    public String hello2( @RequestParam( value = "name" ) String name ) {
	return "hystrix - fuck - 2 - " + name;
    }

    @Override
    public String hello3( @RequestParam( value = "name" ) String name ) {
	return "hystrix - fuck - 3 - " + name;
    }

}
