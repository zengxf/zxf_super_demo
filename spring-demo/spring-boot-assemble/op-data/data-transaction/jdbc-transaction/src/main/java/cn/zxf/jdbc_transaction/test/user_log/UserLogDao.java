package cn.zxf.jdbc_transaction.test.user_log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserLogDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private long         index = 100;

    public UserLog save( UserLog log ) {
        jdbcTemplate.update( "insert into user_log(id, user_id, msg) values(?,?,?)", index, log.getUserId(), log.getMsg() );
        log.setId( index );
        index++;
        return log;
    }

}
