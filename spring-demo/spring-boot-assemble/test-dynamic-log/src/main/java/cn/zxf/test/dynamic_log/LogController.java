package cn.zxf.test.dynamic_log;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping( "/api/log" )
@Slf4j
public class LogController {

    @GetMapping( "test" )
    public Object test() {
        log.debug( "test --------------- debug" );
        log.info( "test --------------- info" );
        log.warn( "test --------------- warn" );
        return "true";
    }

}
