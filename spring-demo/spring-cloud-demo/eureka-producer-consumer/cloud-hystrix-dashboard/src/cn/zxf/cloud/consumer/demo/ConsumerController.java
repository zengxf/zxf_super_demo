package cn.zxf.cloud.consumer.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ConsumerController {

    @Autowired
    HelloRemote helloRemote;

    @RequestMapping( "/hello/{name}" )
    public String index( //
            @PathVariable( "name" ) String name //
    ) {
	String message = helloRemote.hello( name );
	log.info( "hello message: {}", message );
	return message;
    }

    @SuppressWarnings( "deprecation" )
    @RequestMapping( "/hello-j8/{name}" )
    public String hello_j8( //
            @PathVariable( "name" ) String name //
    ) {
	String message = helloRemote.hello_j8( name );
	log.info( "hello-j8 message: {}", message );
	return message;
    }

}