package cn.zxf.test.initialize.aop;

import java.time.LocalDateTime;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeHandler {

    public void printTimeStart() {
        log.info( "\nCurrentTime: {}", LocalDateTime.now() );
    }

    public void printTimeEnd() {
        log.info( "CurrentTime: {} \n", LocalDateTime.now() );
    }

}
