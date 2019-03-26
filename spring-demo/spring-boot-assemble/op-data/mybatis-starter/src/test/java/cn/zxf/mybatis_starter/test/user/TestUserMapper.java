package cn.zxf.mybatis_starter.test.user;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.NONE )
@RunWith( SpringRunner.class )
public class TestUserMapper {

    @Autowired
    private UserMapper mapper;

    @Test
    public void insert() {
        User user = User.builder()
                .name( "zxf" )
                .age( 22 )
                .build();
        log.info( "truly-user: {}", user );
        mapper.insert( user );
        log.info( "inserted-user: {}", mapper.findById( user.getId() ) );
    }

    @Test
    public void findStatus() {
        User user = User.builder()
                .name( "zxf" )
                .age( 66 )
                .status( 1 )
                .build();
        mapper.insert( user );
        log.info( "inserted-user: {}", user );
        log.info( "user-status: {}", mapper.findStatus( user.getId() ) );
    }

    @Test
    public void update() {
        User user = User.builder()
                .id( 1L )
                .name( "zxf" )
                .age( 22 )
                .loginMobile( "134-0000-3333" )
                .build();
        log.info( "truly-user: {}", user );
        mapper.update( user );
        log.info( "updated-user: {}", mapper.findById( 1L ) );
    }

    @Test
    public void findListByKey() {
        List<User> list = mapper.findListByKey( "zxf" );
        list.forEach( user -> log.info( "user: {}", user ) );
    }

    @Test
    public void updateFieldNullable() {
        User user = User.builder()
                .id( 1L )
                .name( "ss" )
                .age( 32 )
                .build();
        log.info( "truly-user: {}", user );
        mapper.updateFieldNullable( user );
        log.info( "updated-user: {}", mapper.findById( 1L ) );

        user.setName( null );
        user.setAge( 33 );
        log.info( "truly-user: {}", user );
        mapper.updateFieldNullable( user );
        log.info( "updated-user: {}", mapper.findById( 1L ) );
    }

    // -------------
    // -------------

    static void getUpdateSql() {
        User user = User.builder()
                .id( 1L )
                .name( "zxf" )
                .age( 22 )
                .build();
        log.info( "sql: \n{}", UserMapper.SqlBuilder.buildUpdate( user ) );
        user.setName( null );
        log.info( "sql: \n{}", UserMapper.SqlBuilder.buildUpdate( user ) );
    }

    public static void main( String[] args ) {
        getUpdateSql();
    }

}
