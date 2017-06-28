package cn.zxf.cloud.producer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.zxf.cloud.entity.UserDto;
import cn.zxf.cloud.simple.SimpleDto;

@RestController
public class HelloController {

    @RequestMapping( "/hello" )
    public String index( @RequestParam String name ) {
	if ( System.currentTimeMillis() % 3 == 0 ) {
	    throw new RuntimeException( "error !!!" );
	}
	return "hello " + name + "，this is first messge";
    }

    @GetMapping( "/user-prod" )
    public UserDto findUser() {
	UserDto.HomeDto home = UserDto.HomeDto.builder()//
	        .address( "天河" )//
	        .build();
	return UserDto.builder()//
	        .age( 23 )//
	        .userName( "zxf" )//
	        .home( home )//
	        .build();
    }

    @GetMapping( "/simple1" )
    public SimpleDto simple1() {
	return SimpleDto.builder()//
	        .age( 23 )//
	        .name( "zxf" )//
	        .build();
    }

}