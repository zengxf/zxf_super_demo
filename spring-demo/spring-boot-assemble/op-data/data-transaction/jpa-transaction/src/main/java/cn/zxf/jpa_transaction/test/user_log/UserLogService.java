package cn.zxf.jpa_transaction.test.user_log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UserLogService {

    @Autowired
    private UserLogRepository dao;

    public UserLog createNonTransaction( Long userId ) {
        UserLog userLog = UserLog.builder()
                .msg( "无事务" )
                .userId( userId )
                .build();
        dao.save( userLog );
        log.info( "user-log: {}", userLog );
        return userLog;
    }

    @Transactional( propagation = Propagation.REQUIRED )
    public UserLog createTransactionalRequired( Long userId, String sign ) {
        UserLog userLog = UserLog.builder()
                .msg( "事务-Required" )
                .userId( userId )
                .build();
        dao.save( userLog );
        log.info( "user-log: {}", userLog );
        this.checkSign( sign );
        return userLog;
    }

    @Transactional( propagation = Propagation.SUPPORTS )
    public UserLog createTransactionalSupports( Long userId, String sign ) {
        UserLog userLog = UserLog.builder()
                .msg( "事务-Supports" )
                .userId( userId )
                .build();
        dao.save( userLog );
        log.info( "user-log: {}", userLog );
        this.checkSign( sign );
        return userLog;
    }

    @Transactional( propagation = Propagation.MANDATORY )
    public UserLog createTransactionalMandatory( Long userId, String sign ) {
        UserLog userLog = UserLog.builder()
                .msg( "事务-Mandatory" )
                .userId( userId )
                .build();
        dao.save( userLog );
        log.info( "user-log: {}", userLog );
        this.checkSign( sign );
        return userLog;
    }

    @Transactional( propagation = Propagation.REQUIRES_NEW )
    public UserLog createTransactionalRequiresNew( Long userId, String sign ) {
        UserLog userLog = UserLog.builder()
                .msg( "事务-RequiresNew" )
                .userId( userId )
                .build();
        dao.save( userLog );
        log.info( "user-log: {}", userLog );
        this.checkSign( sign );
        return userLog;
    }

    @Transactional( propagation = Propagation.NOT_SUPPORTED )
    public UserLog createTransactionalNotSupported( Long userId, String sign ) {
        UserLog userLog = UserLog.builder()
                .msg( "事务-NotSupported" )
                .userId( userId )
                .build();
        dao.save( userLog );
        log.info( "user-log: {}", userLog );
        this.checkSign( sign );
        return userLog;
    }

    @Transactional( propagation = Propagation.NEVER )
    public UserLog createTransactionalNever( Long userId, String sign ) {
        UserLog userLog = UserLog.builder()
                .msg( "事务-Never" )
                .userId( userId )
                .build();
        dao.save( userLog );
        log.info( "user-log: {}", userLog );
        this.checkSign( sign );
        return userLog;
    }

    @Transactional( propagation = Propagation.NESTED )
    public UserLog createTransactionalNested( Long userId, String sign ) {
        UserLog userLog = UserLog.builder()
                .msg( "事务-Nested" )
                .userId( userId )
                .build();
        dao.save( userLog );
        log.info( "user-log: {}", userLog );
        this.checkSign( sign );
        return userLog;
    }

    // ---------
    // ---------

    private void checkSign( String sign ) {
        if ( "err".equals( sign ) )
            throw new RuntimeException( "Transactional Error Test" );
    }

}
