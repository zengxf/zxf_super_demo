package cn.zxf.unit_test.position;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import cn.zxf.unit_test.AbstractApplicationTest;
import cn.zxf.unit_test.position.dto.PositionDto;

public class PositionServiceTest extends AbstractApplicationTest {

    @Autowired
    private PositionService  service;
    @MockBean
    private PositionMongoDao dao;

    @Test
    public void findAll() {
	Mockito.when( dao.findAll() ).thenReturn( Arrays.asList( new Position( "123", "test-1", 2 ) ) );
	List<PositionDto> list = service.findAll();
	super.info( "list: {}", list );
    }

}
