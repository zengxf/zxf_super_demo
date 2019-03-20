package cn.zxf.spring_research.filter;

import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONObject;
import org.reactivestreams.Publisher;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.http.server.reactive.ServerHttpResponseDecorator;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class ChangeResponseBodyFilter implements GlobalFilter, Ordered {

    @Override
    public int getOrder() {
        return -2;
    }

    @Override
    public Mono<Void> filter( ServerWebExchange exchange, GatewayFilterChain chain ) {
        log.info( "ChangeResponseBodyFilter entry ..." );

        ServerHttpResponse originalResponse = exchange.getResponse();
        // DataBufferFactory bufferFactory = originalResponse.bufferFactory();

        ServerHttpResponseDecorator decoratedResponse = new ServerHttpResponseDecorator( originalResponse ) {
            @Override
            public Mono<Void> writeWith( Publisher<? extends DataBuffer> body ) {
                if ( body instanceof Flux ) {
                    // HttpHeaders headers = super.getHeaders();
                    Flux<? extends DataBuffer> fluxBody = (Flux<? extends DataBuffer>) body;
                    Flux<DataBuffer> data = fluxBody.map( dataBuffer -> {
                        // String returnStr = returnContent( dataBuffer );
                        // byte[] returnArr = returnStr.getBytes();
                        // headers.setContentLength( returnArr.length );
                        // return bufferFactory.wrap( returnArr );
                        return dataBuffer;
                    } );
                    return super.writeWith( data );
                }
                return super.writeWith( body );
            }
        };
        return chain.filter( exchange.mutate()
                .response( decoratedResponse )
                .build() );
    }

    static String returnContent( DataBuffer dataBuffer ) {
        byte[] content = new byte[dataBuffer.capacity()];
        dataBuffer.read( content );
        DataBufferUtils.release( dataBuffer ); // 释放掉内存

        // 下面就是 response 的值，想修改、查看就随意而为了
        String contentStr = new String( content, Charset.forName( "UTF-8" ) );
        log.info( "response-content: {}", contentStr );

        String returnStr = "json-error";
        try {
            returnStr = new JSONObject() //
                    .put( "status", "ok" )
                    .put( "content", new JSONObject( contentStr ) )
                    .toString();
        } catch ( JSONException e ) {
            log.error( "json-error", e );
        }

        return returnStr;
    }

}
