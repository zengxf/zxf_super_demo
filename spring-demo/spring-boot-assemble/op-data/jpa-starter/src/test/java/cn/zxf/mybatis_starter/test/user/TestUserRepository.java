package cn.zxf.mybatis_starter.test.user;

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
        User user = User.builder()
                .name( name )
                .loginMobile( "bb" )
                .build();
        repos.save( user );
        log.info( "insert-user: {}", user );
        log.info( "find-list-user: {}", repos.findByName( name ) );
        user.setLoginMobile( "bb-cc" );
        repos.save( user );
        log.info( "find-list-user: {}", repos.findByName( name ) );
        repos.deleteById( user.getId() );
        log.info( "find-list-user: {}", repos.findByName( name ) );
    }

}
