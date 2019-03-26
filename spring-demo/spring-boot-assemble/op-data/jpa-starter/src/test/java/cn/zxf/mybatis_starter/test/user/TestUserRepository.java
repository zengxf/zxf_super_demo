package cn.zxf.mybatis_starter.test.user;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.NONE )
@RunWith( SpringRunner.class )
public class TestUserRepository {

    @Autowired
    private UserRepository repos;

    @Test
    public void findCURD() {
        String name = "zxf-aa";
        User user = new User().name( name )
                .loginMobile( "bb" );
        repos.save( user );
        log.info( "inserted-user: {}", user );
        Integer id = user.id();

        user = repos.findById( id )
                .get()
                .loginMobile( "bb-cc" )
                .lastLoginDate( new Date() );
        repos.save( user );

        user = repos.findById( id )
                .get();
        log.info( "find-list-user: {}", user );
    }

}
