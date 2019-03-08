package cn.zxf.testwebflux.test;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import cn.zxf.testwebflux.user.User;
import reactor.core.publisher.Mono;

public class TestWebTestClient {

    private final WebTestClient client = WebTestClient.bindToServer()
            .baseUrl( "http://localhost:8088" )
            .build();

    @Test
    public void testCreateUser() throws Exception {
        final User user = new User();
        user.setId( "3" );
        user.setName( "Test" );
        client.post()
                .uri( "/user" )
                .contentType( MediaType.APPLICATION_JSON )
                .body( Mono.just( user ), User.class )
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody()
                .jsonPath( "name" )
                .isEqualTo( "Test" );
    }

}
