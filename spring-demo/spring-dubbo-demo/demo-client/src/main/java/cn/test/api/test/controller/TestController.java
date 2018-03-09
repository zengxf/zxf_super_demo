package cn.test.api.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;

import cn.test.api.ISay;
import cn.test.api.IUserRpc;
import cn.test.api.UserDto;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping( "/test/say" )
public class TestController {

    @Autowired
    private ISay     say;
    @Reference( version = "1.0.0", check = false, retries = 0, timeout = 3000 )
    private IUserRpc userRpc;

    /**
     * @URL def http://localhost:8060/test/say/hello
     * @URL test http://localhost:8061/test/say/hello
     * @param message
     * @return
     */
    @RequestMapping( "{message}" )
    public String test( @PathVariable String message ) {
        say.say( message );
        return "ok!";
    }

    /**
     * @URL def http://localhost:8060/test/say/user/001
     * @URL test http://localhost:8061/test/say/user/001
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
