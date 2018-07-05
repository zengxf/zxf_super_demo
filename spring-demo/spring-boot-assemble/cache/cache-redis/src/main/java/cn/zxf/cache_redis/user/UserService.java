package cn.zxf.cache_redis.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Component;

import cn.zxf.cache_redis.user.dto.JwtUser;
import cn.zxf.cache_redis.user.dto.NavigationTabDto;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UserService {

    @Autowired
    private UserService self;

    static final String key_1 = "'zxf-user:' + #user.id";

    @CachePut( value = "zxf-user", key = "'zxf-user:' + #user.id" )
    public void save( User user ) {
        log.info( "save - user: {}", user );
    }

    @CachePut( value = "zxf-user", key = key_1 )
    public User saveAndGet( User user ) {
        user.setStatus( 2 );
        log.info( "saveAndGet - user: {}", user );
        return user;
    }

    @Cacheable( value = "user", key = "#id" )
    public User findOne( String id ) {
        User user = User.builder()
                .id( id )
                .name( "test-" + id )
                .status( 1 )
                .build();
        log.info( "findOne - user: {}", user );
        return user;
    }

    @Cacheable( value = "user", key = "#user.id" )
    public User findOne( User user ) {
        user.setName( "test-" + user.getId() );
        log.info( "findOne - user: {}", user );
        return user;
    }

    @CacheEvict( value = "user", key = "#id" )
    public void delete( String id ) {
        log.info( "delete - id: {}", id );
    }

    @Caching( cacheable = @Cacheable( value = "user", key = "#id" ) )
    public User common( String id, Integer status ) {
        User user = User.builder()
                .id( id )
                .name( "test-" + id )
                .status( status )
                .build();
        log.info( "common - user: {}", user );
        return user;
    }

    @Cacheable( value = "user", key = "'zxf:' + #id", unless = "#result == null || #result.status == 1 || #result.id.startsWith( 'xx-' )" )
    public User cacheCondition( String id, Integer status ) {
        User user = User.builder()
                .id( id )
                .name( "test-" + id )
                .status( status )
                .build();
        log.info( "cacheCondition - user: {}", user );
        return user;
    }

    @Cacheable( value = "user", key = "'navigation:' + #userId", unless = "!#result.showFinance || !#result.showReceiveCandidate" )
    public NavigationTabDto navigation( String userId ) {
        NavigationTabDto dto = NavigationTabDto.builder()
                .showFinance( userId.startsWith( "zxf" ) )
                .showReceiveCandidate( true )
                .build();
        log.info( "navigation - user-id: {}, dto: {}", userId, dto );
        return dto;
    }

    public JwtUser loginNullable( String username ) {
        return self.login( username );
    }

    @Cacheable( value = "user", key = "'login-user:' + #username", //
            unless = "#result == null || #username.startsWith( '1-' ) || #result.authorities.isEmpty()" )
    public JwtUser login( String username ) {
        log.info( "login: {}", username );
        JwtUser user = new JwtUser();
        user.setUsername( username );
        if ( username.startsWith( "1-" ) )
            user.addAuthority( "admin" );
        if ( username.startsWith( "3-xx" ) ) {
        }
        if ( username.startsWith( "3-zxf" ) )
            user.addAuthority( "user" );
        if ( username.startsWith( "xx" ) )
            return null;
        if ( username.startsWith( "error" ) )
            throw new RuntimeException( "login-error" );
        return user;
    }

    @Cacheable( value = "user", key = "'login-user:' + #username" )
    public JwtUser loginSimple( String username ) {
        log.info( "login: {}", username );
        JwtUser user = new JwtUser();
        user.setUsername( username );
        user.addAuthority( "admin" );
        return user;
    }

}
