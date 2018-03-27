package cn.zxf.jpa_transaction.test.position;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class NonPublicPositionService {

    @Transactional( propagation = Propagation.REQUIRED )
    Position defCreateTransactionalRequired( String name, String sign ) {
        return Position.builder()
                .name( "test" )
                .build();
    }

    @Transactional( propagation = Propagation.REQUIRED )
    private Position privateCreateTransactionalRequired( String name, String sign ) {
        return Position.builder()
                .name( "test" )
                .build();
    }

    @Transactional( propagation = Propagation.REQUIRED )
    protected Position protectedCreateTransactionalRequired( String name, String sign ) {
        return Position.builder()
                .name( "test" )
                .build();
    }

}
