package cn.zxf.web_socket.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class GreetingController {

    @Autowired
    private SimpMessagingTemplate temp;

    @MessageMapping( "/hello" )
    @SendTo( "/topic/greetings" )
    public Greeting greeting( HelloMessage message ) throws Exception {
        log.info( "recive-message: {}", message );
        // Thread.sleep( 1000 ); // simulated delay
        return new Greeting( "Hello, " + HtmlUtils.htmlEscape( message.getName() ) + "!" );
    }

    /** 点对点发送 */
    @MessageMapping( "/private-chat" )
    public void privateChat() {
        String name = "zxf-001";
        log.info( "user-name: {}", name );
        temp.convertAndSendToUser( name, "/test-private-chat", new Greeting( "test-私信" ) );
    }

}
