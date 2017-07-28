package cn.zxf.unit_test.position;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.zxf.unit_test.AbstractApplicationTest;
import cn.zxf.unit_test.position.dto.PositionDto;

public class PositionServiceTest extends AbstractApplicationTest {

    @Autowired
    private PositionService service;

    @Test
    public void findAll() {
	List<PositionDto> list = service.findAll();
	info( "list: {}", list );
    }

}
