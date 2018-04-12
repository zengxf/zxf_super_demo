package cn.zxf.ds_druid.test.user;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UserService {

    @Autowired
    private UserRepository dao;
    @Autowired
    private JdbcTemplate   temp;
    private long           index = 100;

    @Autowired
    private DataSource     ds;

    @PostConstruct
    public void init() {
        log.info( "ds: {}", ds );
    }

    public User createNonTransaction( String name ) {
        User user = User.builder()
                .name( name )
                .age( 22 )
                .build();
        dao.save( user );

        log.info( "user: {}", user );
        return user;
    }

    public List<User> findAll() {
        return dao.findAll();
    }

    public Long createBySql( String name ) {
        temp.update( "insert into user(id, name, age) values(?,?,?)", index, name, 23 );
        index++;
        return index;
    }

    public Long createByDirectSql( String name ) {
        temp.update( String.format( "insert into user(id, name, age) values(%d,'%s',%d)", index, name, 23 ) );
        index++;
        return index;
    }

    public String executeIllegalSql() {
        RowCallbackHandler rch = rs -> {
            while ( rs.next() ) {
                log.info( "{} - {}", rs.getObject( 1 ), rs.getObject( 2 ) );
            }
        };
        temp.query( "select * from user where id='1' and len(@@version)>0 and '1'='1'", rch );
        return "true";
    }

    public String executeMultiSql() {
        RowCallbackHandler rch = rs -> {
            while ( rs.next() ) {
                log.info( "{} - {}", rs.getObject( 1 ), rs.getObject( 2 ) );
            }
        };
        temp.query( "SELECT * FROM mysql.`user`", rch );
        return "true";
    }

}
