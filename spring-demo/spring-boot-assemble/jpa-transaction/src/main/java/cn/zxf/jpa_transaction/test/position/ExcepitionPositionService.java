package cn.zxf.jpa_transaction.test.position;

import java.sql.SQLDataException;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ExcepitionPositionService {

    @Transactional( propagation = Propagation.REQUIRED, rollbackFor = SQLDataException.class )
    public Position createTransactionalRequired( String name, String sign ) throws SQLDataException {
        throw new SQLDataException( "XXXXX" );
    }

}
