package cn.zxf.configuration.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.zxf.configuration.test.config.position.AutoPositionConfig;
import cn.zxf.configuration.test.config.position.PositionConfig;
import cn.zxf.configuration.test.config.user.User;
import cn.zxf.configuration.test.config.user.UserConfig;
import lombok.extern.slf4j.Slf4j;

@SuppressWarnings( "deprecation" )
@Slf4j
@SpringBootTest
@RunWith( SpringRunner.class )
public class TestConfig {

    @Autowired
    private UserConfig         userCfg;
    @Autowired
    private User               user;
    @Autowired
    private PositionConfig     positionCfg;
    @Autowired
    private AutoPositionConfig autoPositionCfg;

    @Test
    public void testPrint() {
        log.info( "user-config: {}", userCfg );
        log.info( "user: {}", user );
        log.info( "position-config: {}", positionCfg );
        log.info( "auto-position-config: {}", autoPositionCfg );
    }

}
