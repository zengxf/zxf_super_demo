package cn.zxf.jpa_starter.test.user;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserDao {

    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private JdbcTemplate  jdbc;

    public Object findOneOnlyColumn( Integer id ) {
        String sql = "SELECT id, status FROM user WHERE id = ?1";
        return entityManager.createNativeQuery( sql )
                .setParameter( 1, id )
                .getSingleResult();
    }

    public User findOneOnlyColumnA( Integer id ) {
        String jsql = "SELECT NEW cn.zxf.jpa_starter.test.user.User(u.id, u.status) FROM User u WHERE u.id = ?1";
        return entityManager.createQuery( jsql, User.class )
                .setParameter( 1, id )
                .getSingleResult();
    }

    // error
    public User findOneOnlyColumnB( Integer id ) {
        return entityManager.createQuery( "SELECT NEW cn.zxf.jpa_starter.test.user.User().id(u.id).status(u.status) " //
                + " FROM User u WHERE u.id = ?1", User.class )
                .setParameter( 1, id )
                .getSingleResult();
    }

    @Transactional
    public void batchSave( List<User> list ) {
        int batchSize = 3;
        for ( int i = 0; i < list.size(); ) {
            entityManager.persist( list.get( i ) );
            ++i;
            if ( i % batchSize == 0 || i == list.size() ) {
                entityManager.flush();
            }
        }
    }

    @Transactional
    public void batchSaveByJdbc( List<User> list ) {
        String sql = "insert \r\n" + //
                "    into\r\n" + //
                "        user\r\n" + //
                "        (login_mobile, name) \r\n" + //
                "    values\r\n" + //
                "        (?, ?)";
        System.out.println( sql );

        jdbc.batchUpdate( sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues( PreparedStatement ps, int i ) throws SQLException {
                User user = list.get( i );
                ps.setObject( 1, user.loginMobile() );
                ps.setObject( 2, user.name() );
            }

            @Override
            public int getBatchSize() {
                return list.size();
            }
        } );
    }

}
