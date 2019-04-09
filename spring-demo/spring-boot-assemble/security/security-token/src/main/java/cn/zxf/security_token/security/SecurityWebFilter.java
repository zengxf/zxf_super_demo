package cn.zxf.security_token.security;

import java.util.Map;
import java.util.Set;

import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class SecurityWebFilter implements WebFilter {

    private static final Set<String> NO_AUTH_PATHS;
    public static final String       CUR_USER_ID_KEY = "cur-user-id";

    static {
        NO_AUTH_PATHS = Set.of( "/api/security/login" );
    }

    @Override
    public Mono<Void> filter( ServerWebExchange exchange, WebFilterChain chain ) {
        ServerHttpRequest request = exchange.getRequest();
        String path = request.getPath()
                .value();
        log.info( "{} request: {}", request.getRemoteAddress(), path );

        if ( NO_AUTH_PATHS.contains( path ) )
            return chain.filter( exchange );

        String token = request.getHeaders()
                .getFirst( "Authentication-Token" );
        Integer userId = TokenUtils.parse( token );
        if ( userId != null ) {
            request = request.mutate()
                    .header( CUR_USER_ID_KEY, userId.toString() )
                    .build();
            return chain.filter( exchange.mutate()
                    .request( request )
                    .build() );
        }

        return this.errorResponse( exchange );
    }

    private Mono<Void> errorResponse( ServerWebExchange exchange ) {
        ServerHttpResponse response = exchange.getResponse();
        HttpHeaders headers = response.getHeaders();
        String json = toJson( Map.of( "error", "1", "reason", "token invalid" ) );
        byte[] content = json.getBytes();
        DataBuffer wrap = response.bufferFactory()
                .wrap( content );
        response.setStatusCode( HttpStatus.UNAUTHORIZED );
        headers.add( "Content-Type", "application/json;charset=UTF-8" );
        headers.add( "Content-Length", content.length + "" );
        return response.writeWith( Mono.just( wrap ) );
    }

    private static String toJson( Map<String, Object> map ) {
        try {
            return new ObjectMapper().writeValueAsString( map );
        } catch ( JsonProcessingException e ) {
            log.error( "to json error! map: {}", map, e );
        }
        return "";
    }

}
