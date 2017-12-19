package cn.zxf.spring.small.function.event.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main( String[] args ) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext( EventConfig.class );

        log.info( "main context: [{}]", context );

        DemoPublisher demoPublisher = context.getBean( DemoPublisher.class );

        demoPublisher.publish( "hello application event" );

        context.close();
    }
}
