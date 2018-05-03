package cn.zxf.async.test.user;

import java.net.URI;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

public class TestUserController {

    @Test
    public void test_Async() {
        RestTemplate rest = new RestTemplate();
        Object res = rest.getForEntity( URI.create( "http://localhost:9080/api/user/async" ), Object.class );
        System.out.println( "res: " + res );
    }

    @Test
    public void testAsync() {
        RestTemplate rest = new RestTemplate();
        Object res = rest.getForEntity( URI.create( "http://localhost:9080/api/user/testAsync" ), Object.class );
        System.out.println( "res: " + res );
    }

    @Test
    public void testAsyncError() {
        RestTemplate rest = new RestTemplate();
        Object res = rest.getForEntity( URI.create( "http://localhost:9080/api/user/testAsyncError" ), Object.class );
        System.out.println( "res: " + res );
    }

    @Test
    public void testSync() {
        RestTemplate rest = new RestTemplate();
        Object res = rest.getForEntity( URI.create( "http://localhost:9080/api/user/testSync" ), Object.class );
        System.out.println( "res: " + res );
    }

}
