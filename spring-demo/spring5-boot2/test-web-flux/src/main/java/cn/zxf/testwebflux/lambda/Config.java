package cn.zxf.testwebflux.lambda;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

@Configuration
public class Config {

    // http://localhost:8088/calculator?operator=add&v1=2&v2=3
    @SuppressWarnings( "unchecked" )
    @Bean
    public RouterFunction<ServerResponse> routerFunction( CalculatorHandler calculatorHandler ) {
        return RouterFunctions.route( RequestPredicates.path( "/calculator" ), //
                request -> request.queryParam( "operator" )
                        .map( operator -> Mono.justOrEmpty( ReflectionUtils.findMethod( CalculatorHandler.class, operator, ServerRequest.class ) )
                                .flatMap( method -> (Mono<ServerResponse>) ReflectionUtils.invokeMethod( method, calculatorHandler, request ) )
                                .switchIfEmpty( ServerResponse.badRequest()
                                        .build() )
                                .onErrorResume( ex -> ServerResponse.status( HttpStatus.INTERNAL_SERVER_ERROR )
                                        .build() ) )
                        .orElse( ServerResponse.badRequest()
                                .build() ) );
    }

}