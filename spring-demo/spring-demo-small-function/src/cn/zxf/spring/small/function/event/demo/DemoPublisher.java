package cn.zxf.spring.small.function.event.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DemoPublisher {
    @Autowired
    ApplicationContext applicationContext;

    public void publish( String msg ) {
        log.info( "DemoPublisher context: [{}]", applicationContext );
        applicationContext.publishEvent( new DemoEvent( this, msg ) );
    }

}
