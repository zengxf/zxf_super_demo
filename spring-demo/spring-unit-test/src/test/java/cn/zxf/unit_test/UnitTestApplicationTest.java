package cn.zxf.unit_test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;

public class UnitTestApplicationTest extends AbstractApplicationTest {

    @Value( "${server.port}" )
    private int port;

    @Test
    public void print() {
	super.info( "port: {}", port );
    }

}
