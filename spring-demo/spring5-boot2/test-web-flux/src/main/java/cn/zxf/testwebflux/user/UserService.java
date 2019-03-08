package cn.zxf.testwebflux.user;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import cn.zxf.testwebflux.common.ResourceNotFoundException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
class UserService {
    
    private final Map<String, User> data = new ConcurrentHashMap<>();

    Flux<User> list() {
        return Flux.fromIterable( this.data.values() );
    }

    Flux<User> getById( final Flux<String> ids ) {
        return ids.flatMap( id -> Mono.justOrEmpty( this.data.get( id ) ) );
    }

    Mono<User> getById( final String id ) {
        return Mono.justOrEmpty( this.data.get( id ) )
                .switchIfEmpty( Mono.error( new ResourceNotFoundException() ) );
    }

    Mono<User> createOrUpdate( final User user ) {
        this.data.put( user.getId(), user );
        return Mono.just( user );
    }

    Mono<User> delete( final String id ) {
        return Mono.justOrEmpty( this.data.remove( id ) );
    }
    
}