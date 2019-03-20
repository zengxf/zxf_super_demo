package cn.zxf.jpa_transaction.test.position;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 直接报错：java.lang.IllegalArgumentException: Cannot subclass final class cn.zxf.web.test.position.FinalInterfacePositionService
 * 
 * <p>
 * Created by zengxf on 2018-03-26
 */
// @Component
@Deprecated
public final class FinalInterfacePositionService implements IPositionService {

    @Transactional( propagation = Propagation.REQUIRED )
    public Position createTransactionalRequired( String name, String sign ) {
        return Position.builder()
                .name( "test" )
                .build();
    }

}
