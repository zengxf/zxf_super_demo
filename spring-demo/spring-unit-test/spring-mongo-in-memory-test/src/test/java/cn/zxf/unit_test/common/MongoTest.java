package cn.zxf.unit_test.common;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import de.svenkubiak.embeddedmongodb.EmbeddedMongo;

public class MongoTest extends LogUtil {

    @BeforeClass
    public static void startup() {
	info( "startup mongodb ..." );
	EmbeddedMongo.DB.port( 28028 ).start();
    }

    @AfterClass
    public static void shutdown() {
	info( "\n shutdown mongodb ..." );
	EmbeddedMongo.DB.stop();
    }

    @Test
    public void test_connection() {
	info( "test" );
    }

}
