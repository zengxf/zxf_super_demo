package cn.zxf.jpa_transaction.test.explore_principle.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import cn.zxf.jpa_transaction.test.user.User;
import cn.zxf.jpa_transaction.test.user_log.UserLog;

class SessionFactoryUtils {

    static SessionFactory getFactory() throws ExceptionInInitializerError {
        try {
            SessionFactory factory = new Configuration() //
                    .addAnnotatedClass( User.class )
                    .addAnnotatedClass( UserLog.class )
                    .setProperty( "show_sql", "true" )
                    .setProperty( "hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect" )
                    .setProperty( "hibernate.connection.url", "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC" )
                    .setProperty( "hibernate.connection.username", "root" )
                    .setProperty( "hibernate.connection.password", "admin" )
                    .buildSessionFactory();
            return factory;
        } catch ( Throwable ex ) {
            System.err.println( "Failed to create sessionFactory object." + ex );
            throw new ExceptionInInitializerError( ex );
        }
    }

}
