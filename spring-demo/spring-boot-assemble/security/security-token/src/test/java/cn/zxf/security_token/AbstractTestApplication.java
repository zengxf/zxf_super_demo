package cn.zxf.security_token;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.NONE )
@RunWith( SpringRunner.class )
@ActiveProfiles( "dev-token" )
public abstract class AbstractTestApplication {

    @Before
    public void before() {
        log.info( "\n *-*-*-* unit before *-*-*-* \n\n" );
    }

    @After
    public void after() {
        log.info( "\n\n *-*-*-* unit after  *-*-*-* " );
    }

}
