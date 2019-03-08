package cn.zxf.testwebflux.test;

import java.util.Objects;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.reactive.function.BodyExtractors;
import org.springframework.web.reactive.function.client.WebClient;

public class TestSSEClient {

    public static void main( final String[] args ) {
        final WebClient client = WebClient.create();
        client.get()
                .uri( "http://localhost:8088/sse/randomNumbers" )
                .accept( MediaType.TEXT_EVENT_STREAM )
                .exchange()
                .flatMapMany( response -> response.body( BodyExtractors.toFlux( new ParameterizedTypeReference<ServerSentEvent<String>>() {
                } ) ) )
                .filter( sse -> Objects.nonNull( sse.data() ) )
                .map( ServerSentEvent::data )
                .buffer( 10 )
                .doOnNext( System.out::println )
                .blockFirst();
    }

}
