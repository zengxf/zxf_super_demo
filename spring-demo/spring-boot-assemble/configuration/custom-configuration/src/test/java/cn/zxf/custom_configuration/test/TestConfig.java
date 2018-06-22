package cn.zxf.custom_configuration.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import cn.zxf.custom_configuration.test.config.log.LogService;
import cn.zxf.custom_configuration.test.config.position.AutoPositionConfig;
import cn.zxf.custom_configuration.test.config.position.PositionConfig;
import cn.zxf.custom_configuration.test.config.prefile.PrefileConfig;
import cn.zxf.custom_configuration.test.config.prefile.PrefileDevConfig;
import cn.zxf.custom_configuration.test.config.random.RandomConfig;
import cn.zxf.custom_configuration.test.config.user.User;
import cn.zxf.custom_configuration.test.config.user.UserConfig;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@ActiveProfiles( profiles = { "dev", "dubbo", "dubbo-test" } )
@RunWith( SpringRunner.class )
@SuppressWarnings( "deprecation" )
public class TestConfig {

    @Autowired
    private UserConfig               userCfg;
    @Autowired
    private User                     user;
    @Autowired
    private PositionConfig           positionCfg;
    @Autowired
    private AutoPositionConfig       autoPositionCfg;
    @Autowired
    private RandomConfig             randomConfig;
    @Autowired
    private PrefileConfig            prefileConfig;
    @Autowired
    private PrefileDevConfig.IConfig iConfig;
    @Autowired
    private LogService               logService;
    @Value( "${dubbo.name}" )
    private String                   dubboName;

    @Test
    public void testPrint() {
        log.info( "user-config: \n{}", userCfg );
        log.info( "user: \n{}", user );
        log.info( "position-config: \n{}", positionCfg );
        log.info( "auto-position-config: \n{}", autoPositionCfg );
        log.info( "random-config: \n{}", randomConfig );
        log.info( "prefile-config: \n{}", prefileConfig );
        log.info( "prefile-i-config: \n{}", iConfig );
        log.info( "dubbo-name: {}", dubboName );
        logService.testLog();
    }

}
