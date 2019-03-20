package cn.zxf.spring_research.biz;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping( "/api/user" )
public class UserController {

    // http://localhost:9001/api/user/hello
    @GetMapping( "hello" )
    public String hello( //
            @RequestHeader( name = "Hello", required = false ) String content //
    ) {
        log.info( "UserController entry ..." );
        return "hello! header-hello: " + content;
    }

}
