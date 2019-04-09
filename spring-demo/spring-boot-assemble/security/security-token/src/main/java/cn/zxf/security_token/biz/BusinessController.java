package cn.zxf.security_token.biz;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;

import cn.zxf.security_token.security.SecurityWebFilter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping( "/api/biz" )
public class BusinessController {

    @GetMapping( "get-info" )
    public Map<String, Object> getInfo( ServerWebExchange exchange ) {
        log.info( "cur-user-id: {}", exchange.getRequest()
                .getHeaders()
                .getFirst( SecurityWebFilter.CUR_USER_ID_KEY ) );
        return Map.of( "test", "ok" );
    }

}
