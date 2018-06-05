package cn.zxf.bean_get.test;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.zxf.bean_get.test.BeanGetApplication;
import cn.zxf.bean_get.test.user.AbstractUserService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith( SpringRunner.class )
@SpringBootTest
public class TestBeanGetApplication {

    @Test
    public void test_get() {
        Map<String, AbstractUserService> map = BeanGetApplication.CONTEXT.getBeansOfType( AbstractUserService.class );
        log.info( "map: {}", map );
        map.values()
                .forEach( service -> log.info( service.sign ) );
    }

}
