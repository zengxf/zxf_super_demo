package cn.zxf.test.log_file.tag;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping( "/api/log/tag" )
@Slf4j( topic = "my-tag" )
public class TagLogController {

    @GetMapping( "test" )
    public Object test() {
        log.debug( "test ---- debug" );
        log.info( "test ---- info" );
        log.warn( "test ---- warn" );
        log.error( "test ---- error" );
        return "true";
    }

}
