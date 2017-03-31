package cn.zxf.spring.small.function.jms.demo;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @JmsListener( destination = "my-destination" ) // 1
    public void receiveMessage( String message ) {
	System.out.println( "接受到: <" + message + ">" );
    }

}
