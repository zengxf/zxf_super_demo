package cn.zxf.unit_test.position;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.zxf.unit_test.AbstractApplicationTest;

public class PositionMongoDaoTest extends AbstractApplicationTest {

    @Autowired
    private PositionMongoDao dao;

    @Test
    public void test_save() {
	dao.save( Position.builder().id( "zxf" ).name( "feng" ).status( 2 ).build() );
    }

}
