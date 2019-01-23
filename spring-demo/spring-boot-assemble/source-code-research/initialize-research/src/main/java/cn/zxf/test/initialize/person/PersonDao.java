package cn.zxf.test.initialize.person;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class PersonDao {

    public void testInsert() {
        try {
            log.info( "Dao test ..." );
            Thread.sleep( 500 );
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }
    }

}
