package cn.zxf.unit_test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;

public class ParamTestApplicationTest extends AbstractParamApplicationTest {

    @Autowired
    private Environment env;
    @Value( "${server.port}" )
    private int         port;
    @Value( "${test.str}" )
    private String      testStr;

    @Test
    public void print() {
        super.info( "test-str: {}", testStr );
        super.info( "value-port: {}", port );
        super.info( "env-port: {}", env.getProperty( "server.port" ) );
    }

}
