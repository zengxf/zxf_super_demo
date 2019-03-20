package cn.zxf.jdbc_transaction.test.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UserService {

    @Autowired
    private UserDao dao;

    @Transactional( propagation = Propagation.REQUIRED )
    public User createTransactionalRequired( String name, String sign ) {
        User user = User.builder()
                .name( name )
                .age( 24 )
                .build();
        dao.save( user );
        log.info( "user: {}", user );
        return user;
    }

}
