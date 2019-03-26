package cn.zxf.mybatis_starter.test.user;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

@Component
public class UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Deprecated
    public User findOneOnlyColumn( Integer id ) {
        return entityManager.createQuery( "SELECT u FROM User u WHERE u.id = ?1", User.class )
                .setParameter( 1, id )
                .getSingleResult();
    }

}
