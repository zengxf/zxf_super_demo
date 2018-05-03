package cn.zxf.custom_configuration.test.config.log;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class LogService {

    public void testLog() {
        log.trace( "test trace ----------" );
        log.debug( "test debug ----------" );
        log.info( "test info ----------" );
        log.warn( "test warn ----------" );
        log.error( "test error ----------" );
    }

}
