package cn.zxf.security_token.user;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.zxf.security_token.AbstractTestApplication;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestUserRepository extends AbstractTestApplication {

    @Autowired
    private UserRepository repos;

    @Test
    public void testLogin() {
        User user = repos.login( "132" );
        log.info( "user: {}", user );
        user = repos.login( "zxf" );
        log.info( "user: {}", user );
    }

}
