package cn.zxf.webflux.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RestController
@RequestMapping( "/api/test" )
public class TestController {

    @GetMapping( "/create" )
    public Flux<Map<String, Object>> create( @RequestParam String userId ) {
        Map<String, Object> map = new HashMap<>();
        return Flux.just( userId ) //
                .log() //
                .flatMap( r -> Mono.just( r ).subscribeOn( Schedulers.parallel() ), 10 ) //
                .flatMap( id -> {
                    map.put( "user-id", userId );
                    map.put( "user-id-length", userId.length() );
                    return Mono.just( map );
                } );
    }

}
