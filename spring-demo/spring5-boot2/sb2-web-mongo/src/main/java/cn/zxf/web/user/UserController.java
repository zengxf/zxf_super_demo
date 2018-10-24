package cn.zxf.web.user;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/api/user" )
public class UserController {

    // @Autowired
    // private MongoTemplate temp;

    @Autowired
    private UserRepository rep;

    // /api/user/find-one/xx
    @GetMapping( "find-one/{id}" )
    public User findOne( @PathVariable String id ) {
        return rep.findById( id )
                .orElse( null );
    }

    // /api/user/create-one/xx?name=xx
    @GetMapping( "create-one/{id}" )
    public User createOne( @PathVariable String id, @RequestParam String name ) {
        User user = User.builder()
                .id( id )
                .name( name )
                .createDate( new Date() )
                .build();

        rep.insert( user );

        return user;
    }

}
