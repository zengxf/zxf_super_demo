package cn.zxf.spring_research.biz;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.zxf.spring_research.AbstractApplicationTest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestBizService extends AbstractApplicationTest {

    @Autowired
    private List<HelloService> helloServices;

    @Test
    public void hello() {
        this.helloServices.forEach( HelloService::doSomething );
        log.info( "ok!" );
    }

}
