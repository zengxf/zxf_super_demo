package cn.zxf.jpa_transaction.test.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.zxf.jpa_transaction.test.user_log.UserLogService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UserService {

    @Autowired
    private UserRepository dao;

    @Autowired
    private UserLogService logService;

    public User createNonTransaction( String name ) {
        User user = User.builder()
                .name( name )
                .age( 22 )
                .build();
        dao.save( user );

        log.info( "user: {}", user );
        logService.createNonTransaction( user.getId() );
        return user;
    }

    @Transactional( propagation = Propagation.REQUIRED )
    public User createTransactionalRequired( String name, String sign ) {
        User user = User.builder()
                .name( name )
                .age( 24 )
                .build();
        dao.save( user );

        log.info( "user: {}", user );
        logService.createTransactionalRequired( user.getId(), sign );
        return user;
    }

    @Transactional( propagation = Propagation.SUPPORTS )
    public User createTransactionalSupports( String name, String sign ) {
        User user = User.builder()
                .name( name )
                .age( 24 )
                .build();
        dao.save( user );

        log.info( "user: {}", user );
        logService.createTransactionalSupports( user.getId(), sign );
        return user;
    }

    @Transactional( propagation = Propagation.MANDATORY )
    public User createTransactionalMandatory( String name, String sign ) {
        User user = User.builder()
                .name( name )
                .age( 24 )
                .build();
        dao.save( user );

        log.info( "user: {}", user );
        logService.createTransactionalMandatory( user.getId(), sign );
        return user;
    }

    @Transactional( propagation = Propagation.REQUIRES_NEW )
    public User createTransactionalRequiresNew( String name, String sign ) {
        User user = User.builder()
                .name( name )
                .age( 24 )
                .build();
        dao.save( user );

        log.info( "user: {}", user );
        logService.createTransactionalRequiresNew( user.getId(), sign );
        return user;
    }

    @Transactional( propagation = Propagation.NOT_SUPPORTED )
    public User createTransactionalNotSupported( String name, String sign ) {
        User user = User.builder()
                .name( name )
                .age( 24 )
                .build();
        dao.save( user );

        log.info( "user: {}", user );
        logService.createTransactionalNotSupported( user.getId(), sign );
        return user;
    }

    @Transactional( propagation = Propagation.NEVER )
    public User createTransactionalNever( String name, String sign ) {
        User user = User.builder()
                .name( name )
                .age( 24 )
                .build();
        dao.save( user );

        log.info( "user: {}", user );
        logService.createTransactionalNever( user.getId(), sign );
        return user;
    }

    @Transactional( propagation = Propagation.NESTED )
    public User createTransactionalNested( String name, String sign ) {
        User user = User.builder()
                .name( name )
                .age( 24 )
                .build();
        dao.save( user );

        log.info( "user: {}", user );
        logService.createTransactionalNested( user.getId(), sign );
        return user;
    }

}
