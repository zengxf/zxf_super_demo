package cn.zxf.jdbc_transaction.test.user;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User save( User user ) {
        long index = ThreadLocalRandom.current()
                .nextLong();
        jdbcTemplate.update( "insert into user(id, name, age) values(?,?,?)", index, user.getName(), user.getAge() );
        user.setId( index );
        return user;
    }

}
