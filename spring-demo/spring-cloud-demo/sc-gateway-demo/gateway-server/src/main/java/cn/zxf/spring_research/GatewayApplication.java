package cn.zxf.spring_research;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class GatewayApplication {

    public static void main( String[] args ) {
        SpringApplication.run( GatewayApplication.class, args );
    }

    @Bean
    public RouteLocator myRoutes( RouteLocatorBuilder builder ) {
        log.info( "==> route!" );
        return builder.routes()

                // simple
                .route( "test-my-api", p -> p.path( "/api/**" )
                        .filters( f -> f.addRequestHeader( "Hello", "World" ) )
                        .uri( "http://localhost:9001" ) )
                // rewrite
                .route( "test-my-api-rewrite", p -> p.path( "/test/api/**" )
                        .filters( f -> f.addRequestHeader( "Hello", "World" )
                                .rewritePath( "/test/(?<segment>.*)", "/${segment}" ) )
                        .uri( "http://localhost:9001" ) )

                // test baidu load balancer
                .route( "test-baidu-lb", p -> p.path( "/baidu-lb/**" )
                        .filters( f -> f.addRequestHeader( "Hello", "World" ) )
                        .uri( "lb://test-baidu" ) )
                // test baidu
                .route( "test-baidu", p -> p.path( "/baidu/**" )
                        .filters( f -> f.addRequestHeader( "Hello", "World" ) )
                        .uri( "https://www.baidu.com" ) )

                // test core
                .route( "test-core", p -> p.path( "/core/**" )
                        .filters( f -> f.addRequestHeader( "Hello", "World" )
                                .rewritePath( "/core/(?<segment>.*)", "/${segment}" ) )
                        .uri( "http://120.25.93.177:8090" ) )

                .build();
    }
}
