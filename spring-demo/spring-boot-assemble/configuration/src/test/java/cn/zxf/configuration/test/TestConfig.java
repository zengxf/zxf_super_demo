package cn.zxf.configuration.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.zxf.configuration.test.config.User;
import cn.zxf.configuration.test.config.UserConfig;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@RunWith( SpringRunner.class )
public class TestConfig {

    @Autowired
    private UserConfig cfg;
    @Autowired
    private User       user;

    @Test
    public void testPrint() {
        log.info( "config: {}", cfg );
        log.info( "user: {}", user );
    }

}
