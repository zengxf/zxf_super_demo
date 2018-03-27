package cn.zxf.web.test.user_log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UserLogService {

    static final String       ERR_SIGN = "err";

    @Autowired
    private UserLogRepository dao;

    public UserLog createNonTransaction( Long userId ) {
        UserLog userLog = UserLog.builder()
                .msg( "无事务创建" )
                .userId( userId )
                .build();
        dao.save( userLog );
        log.info( "user-log: {}", userLog );
        return userLog;
    }

    @Transactional( propagation = Propagation.REQUIRED )
    public UserLog createTransactionalRequired( Long userId, String sign ) {
        UserLog userLog = UserLog.builder()
                .msg( "事务创建-Required" )
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
                .msg( "事务创建-Supports" )
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
                .msg( "事务创建-Mandatory" )
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
                .msg( "事务创建-RequiresNew" )
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
                .msg( "事务创建-NotSupported" )
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
                .msg( "事务创建-Never" )
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
                .msg( "事务创建-Nested" )
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
        if ( ERR_SIGN.equals( sign ) )
            throw new RuntimeException( "Transactional Error Test" );
    }

}
