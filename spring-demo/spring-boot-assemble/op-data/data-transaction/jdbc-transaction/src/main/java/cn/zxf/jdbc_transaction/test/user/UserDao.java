package cn.zxf.jdbc_transaction.test.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private long         index = 100;

    public User save( User user ) {
        jdbcTemplate.update( "insert into user(id, name, age) values(?,?,?)", index, user.getName(), user.getAge() );
        user.setId( index );
        index++;
        return user;
    }

}
