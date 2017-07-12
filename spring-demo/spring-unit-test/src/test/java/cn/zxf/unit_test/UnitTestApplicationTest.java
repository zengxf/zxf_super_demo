package cn.zxf.unit_test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;

public class UnitTestApplicationTest extends AbstractApplicationTest {

    @Autowired
    private Environment	env;
    @Value( "${server.port}" )
    private int		port;

    @Test
    public void print() {
	super.info( "value-port: {}", port );
	super.info( "env-port: {}", env.getProperty( "server.port" ) );
    }

}
