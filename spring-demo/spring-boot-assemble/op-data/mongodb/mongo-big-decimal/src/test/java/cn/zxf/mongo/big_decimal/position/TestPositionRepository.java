package cn.zxf.mongo.big_decimal.position;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith( SpringRunner.class )
@SpringBootTest
public class TestPositionRepository {

    @Autowired
    private PositionRepository repository;

    @Test
    public void testSave() throws Exception {
        Position p = Position.builder() //
                .name( "java developer" ) //
                .fee( BigDecimal.valueOf( 20000.2 ) ) //
                .desc( "测试2" ) //
                .build();
        repository.insert( p );
        log.info( "insert-id: {}", p.getId() );
    }

    @Test
    public void testSaveNullDecimal() throws Exception {
        Position p = Position.builder() //
                .name( "java developer" ) //
                .desc( "测试-null" ) //
                .build();
        repository.insert( p );
        log.info( "insert-id: {}", p.getId() );
    }

    @Test
    public void testFind() {
        repository.findAll().stream().forEach( p -> log.info( "p: {}", p ) );
    }

}
