package cn.zxf.cloud.consumer.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.zxf.cloud.entity.UserDto;
import cn.zxf.cloud.simple.SimpleDto;
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
	return helloRemote.hello( name );
    }

    @GetMapping( "/user-consum" )
    public UserDto findUser() {
	UserDto user = helloRemote.user();
	log.info( "user: {}", user );
	return user;
    }

    @GetMapping( "/user-consum-str" )
    public String findUserStr() {
	String userStr = helloRemote.userStr();
	log.info( "userStr: {}", userStr );
	return userStr;
    }

    @GetMapping( "/simple1" )
    public SimpleDto simple1() {
	SimpleDto simple1 = helloRemote.simple1();
	log.info( "simple1: {}", simple1 );
	return simple1;
    }

}