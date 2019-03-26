package cn.zxf.mybatis_starter.test.user;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

@Component
public class UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Object findOneOnlyColumn( Integer id ) {
        String sql = "SELECT id, status FROM user WHERE id = ?1";
        return entityManager.createNativeQuery( sql )
                .setParameter( 1, id )
                .getSingleResult();
    }

    public User findOneOnlyColumnA( Integer id ) {
        String jsql = "SELECT NEW cn.zxf.mybatis_starter.test.user.User(u.id, u.status) FROM User u WHERE u.id = ?1";
        return entityManager.createQuery( jsql, User.class )
                .setParameter( 1, id )
                .getSingleResult();
    }

    // error
    public User findOneOnlyColumnB( Integer id ) {
        return entityManager.createQuery( "SELECT NEW cn.zxf.mybatis_starter.test.user.User().id(u.id).status(u.status) " //
                + " FROM User u WHERE u.id = ?1", User.class )
                .setParameter( 1, id )
                .getSingleResult();
    }

}
