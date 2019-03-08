package cn.zxf.reactor_demo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class TestFluxErrorHandle {

    public static void main( String[] args ) throws InterruptedException {
        Flux.just( 1, 2 )
                .concatWith( Mono.error( new IllegalStateException() ) )
                .retry( 1 )
                .subscribe( System.out::println );
    }

}
