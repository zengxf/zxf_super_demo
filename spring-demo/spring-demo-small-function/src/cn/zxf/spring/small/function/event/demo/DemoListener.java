package cn.zxf.spring.small.function.event.demo;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class DemoListener implements ApplicationListener<DemoEvent> {

    public void onApplicationEvent( DemoEvent event ) {

        String msg = event.getMsg();

        System.out.println( "我(bean-demoListener)接受到了bean-demoPublisher发布的消息:" + msg );

    }

}
