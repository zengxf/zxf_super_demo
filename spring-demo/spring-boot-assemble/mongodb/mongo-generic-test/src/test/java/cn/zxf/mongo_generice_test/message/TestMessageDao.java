package cn.zxf.mongo_generice_test.message;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.zxf.mongo_generice_test.AbstractMongoApplicationTest;
import cn.zxf.mongo_generice_test.message.attach.PositionAttach;
import cn.zxf.mongo_generice_test.message.attach.UserAttach;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestMessageDao extends AbstractMongoApplicationTest {

    @Autowired
    private MessageDao dao;

    // @Before
    // public void beforeClear() {
    // dao.clear();
    // }

    // @After
    // public void afterClear() {
    // dao.clear();
    // }

    @Test
    public void testInsert() {
        Message m1 = Message.builder()
                .title( "test 1" )
                .type( 1 )
                .attach( UserAttach.builder()
                        .userId( "u-001" )
                        .userName( "zxf-feng" )
                        .build() )
                .build();

        Message m2 = Message.builder()
                .title( "test 2" )
                .type( 2 )
                .attach( PositionAttach.builder()
                        .positionId( "p-001" )
                        .positionName( "Java Developer" )
                        .positionCity( "广州" )
                        .build() )
                .build();

        dao.insert( m1 );
        dao.insert( m2 );

        log.info( "insert m1: {}", m1 );
        log.info( "insert m2: {}", m2 );
    }

    @Test
    public void testFind() {
        List<Message> list = dao.findAll();
        list.forEach( msg -> log.info( "find message: {}", msg ) );
    }

}
