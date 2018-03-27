package cn.zxf.web.test.position;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CommonPositionService {

    @Transactional( propagation = Propagation.REQUIRED )
    public Position createTransactionalRequired( String name, String sign ) {
        return Position.builder()
                .name( "test" )
                .build();
    }

}
