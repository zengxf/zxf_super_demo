package cn.zxf.testwebflux.websocket;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.server.support.WebSocketHandlerAdapter;

@Configuration
public class WebSocketConfiguration {
    
    // 在线工具测试：https://www.websocket.org/echo.html
    // ws://localhost:8088/echo
    @Bean
    public HandlerMapping webSocketMapping( EchoHandler echoHandler ) {
        final Map<String, WebSocketHandler> map = new HashMap<>( 1 );
        map.put( "/echo", echoHandler );

        final SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
        mapping.setOrder( Ordered.HIGHEST_PRECEDENCE );
        mapping.setUrlMap( map );
        return mapping;
    }

    @Bean
    public WebSocketHandlerAdapter handlerAdapter() {
        return new WebSocketHandlerAdapter();
    }

}
