package cn.zxf.testwebflux.user;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cn.zxf.testwebflux.common.ResourceNotFoundException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping( "/user" )
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController( final UserService userService ) {
        this.userService = userService;
    }

    @ResponseStatus( value = HttpStatus.NOT_FOUND, reason = "Resource not found" )
    @ExceptionHandler( ResourceNotFoundException.class )
    public Mono<String> notFound() {
        return Mono.just( "not-found" );
    }

    // curl http://localhost:8088/user
    @GetMapping( "" )
    public Flux<User> list() {
        return this.userService.list();
    }

    // curl http://localhost:8088/user/2
    @GetMapping( "/{id}" )
    public Mono<User> getById( @PathVariable( "id" ) final String id ) {
        return this.userService.getById( id );
    }

    // curl -H "Content-Type: application/json" -X POST -d "{\"id\": \"2\", \"name\": \"zxx\"}" http://localhost:8088/user
    @PostMapping( "" )
    public Mono<User> create( @RequestBody final User user ) {
        return this.userService.createOrUpdate( user );
    }

    // curl -H "Content-Type: application/json" -X PUT -d "{\"name\": \"zff\"}" http://localhost:8088/user/2
    @PutMapping( "/{id}" )
    public Mono<User> update( @PathVariable( "id" ) final String id, @RequestBody final User user ) {
        Objects.requireNonNull( user );
        user.setId( id );
        return this.userService.createOrUpdate( user );
    }

    // curl -X DELETE http://localhost:8088/user/2
    @DeleteMapping( "/{id}" )
    public Mono<User> delete( @PathVariable( "id" ) final String id ) {
        return this.userService.delete( id );
    }

}