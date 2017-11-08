package cn.test.api.test.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.test.api.ISay;
import cn.test.api.IUserRpc;
import cn.test.api.UserDto;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping( "/test/say" )
public class TestController {

    @Resource
    private ISay     say;
    @Resource
    private IUserRpc userRpc;

    /**
     * @URL http://localhost:8060/test/say/hello
     * @param message
     * @return
     */
    @RequestMapping( "{message}" )
    public String test( @PathVariable String message ) {
        say.say( message );
        return "ok!";
    }

    /**
     * @URL http://localhost:8060/test/say/user/001
     * @param message
     * @return
     */
    @RequestMapping( "/user/{id}" )
    public UserDto user( @PathVariable String id ) {
        UserDto dto = userRpc.find( id );
        log.info( "dto : {}", dto );
        return dto;
    }

}
