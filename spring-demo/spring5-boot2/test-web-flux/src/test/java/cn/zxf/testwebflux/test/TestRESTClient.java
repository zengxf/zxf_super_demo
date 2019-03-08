package cn.zxf.testwebflux.test;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import cn.zxf.testwebflux.user.User;
import reactor.core.publisher.Mono;

public class TestRESTClient {

    public static void main( final String[] args ) {
        final User user = new User();
        user.setId( "1" );
        user.setName( "Test" );
        final WebClient client = WebClient.create( "http://localhost:8088/user" );
        final Mono<User> createdUser = client.post()
                .uri( "" )
                .accept( MediaType.APPLICATION_JSON )
                .body( Mono.just( user ), User.class )
                .exchange()
                .flatMap( response -> response.bodyToMono( User.class ) );
        System.out.println( createdUser.block() );
    }

}
