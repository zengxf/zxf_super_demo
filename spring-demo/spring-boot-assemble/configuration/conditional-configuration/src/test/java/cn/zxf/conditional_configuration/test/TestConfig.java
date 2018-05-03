package cn.zxf.conditional_configuration.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.zxf.conditional_configuration.test.conditional.ConfigConstant;
import cn.zxf.conditional_configuration.test.service.IService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@RunWith( SpringRunner.class )
public class TestConfig implements ConfigConstant {

    @Autowired
    private IService service;

    @Test
    public void testPrint() {
        log.info( "\n\n CUR_TIME: {}, service: {} \n", CUR_TIME, service );
    }

}
