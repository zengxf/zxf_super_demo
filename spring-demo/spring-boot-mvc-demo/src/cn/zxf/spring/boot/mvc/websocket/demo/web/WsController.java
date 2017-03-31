package cn.zxf.spring.boot.mvc.websocket.demo.web;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import cn.zxf.spring.boot.mvc.websocket.demo.domain.WiselyMessage;
import cn.zxf.spring.boot.mvc.websocket.demo.domain.WiselyResponse;

@Controller
public class WsController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;// 1

    @MessageMapping( "/welcome" )
    @SendTo( "/topic/getResponse" )
    public WiselyResponse say( WiselyMessage message ) throws Exception {
	Thread.sleep( 3000 );
	return new WiselyResponse( "Welcome, " + message.getName() + "!" );
    }

    @MessageMapping( "/chat" )
    public void handleChat( Principal principal, String msg ) { // 2
	if ( principal.getName().equals( "wyf" ) ) {// 3
	    messagingTemplate.convertAndSendToUser( "wisely", //
	            "/queue/notifications", principal.getName() + "-send:" + msg );
	} else {
	    messagingTemplate.convertAndSendToUser( "wyf", //
	            "/queue/notifications", principal.getName() + "-send:" + msg );
	}
    }
}