package cn.zxf.jpa_transaction.test.position;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public abstract class AbstractPositionService {

    @Transactional( propagation = Propagation.REQUIRED )
    public Position createTransactionalRequired( String name, String sign ) {
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
