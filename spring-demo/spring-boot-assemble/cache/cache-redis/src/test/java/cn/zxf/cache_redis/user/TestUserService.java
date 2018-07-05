package cn.zxf.cache_redis.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.zxf.cache_redis.user.dto.JwtUser;
import cn.zxf.cache_redis.user.dto.NavigationTabDto;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith( SpringRunner.class )
@SpringBootTest
public class TestUserService {

    @Autowired
    private UserService service;

    @Test
    public void test_save() {
        String id = "zxf-001";
        User user = User.builder()
                .id( id )
                .name( "zxf" )
                .status( 1 )
                .build();
        service.save( user );
        log.info( "test-save-user: {}", user );
    }

    @Test
    public void test_saveAndGet() {
        String id = "zxf-003";
        User user = User.builder()
                .id( id )
                .name( "zxf" )
                .status( 1 )
                .build();
        service.saveAndGet( user );
        log.info( "test-saveAndGet-user: {}", user );
    }

    @Test
    public void test_findOne() {
        String id = "zxf-001";
        User user = service.findOne( id );
        log.info( "test-findOne-user: {}", user );
    }

    @Test
    public void test_findOne2() {
        String id = "zxf-002";
        User user = User.builder()
                .id( id )
                .name( "zxf" )
                .status( 1 )
                .build();
        user = service.findOne( user );
        log.info( "test-findOne-user: {}", user );
    }

    @Test
    public void test_delete() {
        String id = "zxf-002";
        service.delete( id );
        log.info( "test-delete-id: {}", id );
    }

    @Test
    public void test_common() {
        String id = "zxf-004";
        Integer status = 1;
        User user = service.common( id, status );
        log.info( "test-common-id: {}, status: {}, result-user", id, status, user );
    }

    @Test
    public void test_cacheCondition() {
        String id = "zxf-101";
        Integer status = 1;
        User user = service.cacheCondition( id, status );
        log.info( "test-cacheCondition-id: {}, status: {}, result-user", id, status, user );

        id = "zxf-102";
        status = 2;
        user = service.cacheCondition( id, status );
        log.info( "test-cacheCondition-id: {}, status: {}, result-user", id, status, user );

        id = "xx-102";
        status = 1;
        user = service.cacheCondition( id, status );
        log.info( "test-cacheCondition-id: {}, status: {}, result-user", id, status, user );
    }

    @Test
    public void test_navigation() {
        String id = "zxf-101";
        NavigationTabDto result = service.navigation( id );
        log.info( "test-navigation-id: {}, result: {}", id, result );

        result = service.navigation( id );
        log.info( "test-navigation-id: {}, result: {}", id, result );

        id = "xx-102";
        result = service.navigation( id );
        log.info( "test-navigation-id: {}, result: {}", id, result );
    }

    @Test
    public void test_login() {
        JwtUser adminUser = service.login( "1-aa" );
        log.info( "admin: {}", adminUser );
        JwtUser nullUser = service.login( "xx00" );
        log.info( "null-user: {}", nullUser );
        JwtUser goodUser = service.login( "3-zxf001" );
        log.info( "good-user: {}", goodUser );
        JwtUser badUser = service.login( "3-xx001" );
        log.info( "bad-user: {}", badUser );
    }

    @Test
    public void test_loginNullable() {
        JwtUser adminUser = service.loginNullable( "1-aa" );
        log.info( "admin: {}", adminUser );
        JwtUser nullUser = service.loginNullable( "xx00" );
        log.info( "null-user: {}", nullUser );
        JwtUser goodUser = service.loginNullable( "3-zxf001" );
        log.info( "good-user: {}", goodUser );
        JwtUser badUser = service.loginNullable( "3-xx001" );
        log.info( "bad-user: {}", badUser );
        // JwtUser errorUser = service.loginNullable( "error" );
        // log.info( "error-user: {}", errorUser );
    }

    @Test
    public void test_loginSimple() {
        JwtUser adminUser = service.loginSimple( "1-aa" );
        log.info( "admin: {}", adminUser );
        adminUser = service.loginNullable( "1-aa" );
        log.info( "admin: {}", adminUser );
    }

}
