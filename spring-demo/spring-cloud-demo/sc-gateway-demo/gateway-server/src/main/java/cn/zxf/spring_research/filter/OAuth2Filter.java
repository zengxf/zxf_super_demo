package cn.zxf.spring_research.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class OAuth2Filter implements GlobalFilter, Ordered {

    @Override
    public int getOrder() {
        return 10;
    }

    @Override
    public Mono<Void> filter( ServerWebExchange exchange, GatewayFilterChain chain ) {
        log.info( "OAuth2Filter entry ..." );

        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();

        String token = request.getQueryParams()
                .getFirst( "access-token" );
        if ( "123".equals( token ) ) {
            response.setStatusCode( HttpStatus.FOUND );
        } else {
            response.setStatusCode( HttpStatus.BAD_REQUEST );
            response.getHeaders()
                    .add( "X-Auth-Status", "Missing Token" );
            ServerWebExchangeUtils.setAlreadyRouted( exchange );
        }

        return chain.filter( exchange );
    }

}
