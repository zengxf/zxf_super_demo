package cn.zxf.jpa_transaction.test.explore_principle.hibernate;

import static cn.zxf.jpa_transaction.test.explore_principle.hibernate.SessionFactoryUtils.getFactory;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cn.zxf.jpa_transaction.test.user.User;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestNonTransactionSave {

    public static void main( String[] args ) {
        SessionFactory factory = getFactory();

        Session session = factory.openSession();

        try {
            User user = User.builder()
                    .name( "zxf" )
                    .age( 23 )
                    .build();
            log.info( "------------- save -------------" );
            session.save( user );
            log.info( "\n\nsave-user: {}\n\n", user );
        } catch ( HibernateException e ) {
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }

    }

}
