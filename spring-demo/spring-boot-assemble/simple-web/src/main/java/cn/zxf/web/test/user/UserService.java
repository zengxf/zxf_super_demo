package cn.zxf.web.test.user;

import org.springframework.stereotype.Component;

@Component
public class UserService {

    public User getUser() {
        System.out.println( "-- UserService: " + this );
        return User.builder()
                .id( 11L )
                .name( "zxf" )
                .age( 22 )
                .build();
    }

}
