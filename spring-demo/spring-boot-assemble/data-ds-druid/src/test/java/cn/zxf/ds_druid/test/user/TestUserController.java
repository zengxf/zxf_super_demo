package cn.zxf.ds_druid.test.user;

import java.util.Random;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestUserController {

    static final String  root = "http://localhost:9080";

    private RestTemplate rest = new RestTemplate();

    @Test
    public void test_createNonTransaction() {
        Object res = rest.getForEntity( root + "/user/createNonTransaction/zxf-01", Object.class );
        log.info( "res: {}", res );
    }

    @Test
    public void test_createBySql() {
        Object res = rest.getForEntity( root + "/user/createBySql/zxf-11", Object.class );
        log.info( "res: {}", res );
    }

    @Test
    public void test_createByDirectSql() {
        int nameid = new Random().nextInt( 100 ) + 100;
        Object res = rest.getForEntity( root + "/user/createByDirectSql/zxf-" + nameid, Object.class );
        log.info( "res: {}", res );
    }

    @Test
    public void test_findAll() {
        Object res = rest.getForEntity( root + "/user/findAll", Object.class );
        log.info( "res: {}", res );
    }

    @Test
    public void test_executeIllegalSql() {
        Object res = rest.getForEntity( root + "/user/executeIllegalSql", Object.class );
        log.info( "res: {}", res );
    }

    @Test
    public void test_executeMultiSql() {
        Object res = rest.getForEntity( root + "/user/executeMultiSql", Object.class );
        log.info( "res: {}", res );
    }

}
