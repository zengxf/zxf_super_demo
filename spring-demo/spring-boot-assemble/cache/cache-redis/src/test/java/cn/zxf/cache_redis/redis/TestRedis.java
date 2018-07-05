package cn.zxf.cache_redis.redis;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith( SpringRunner.class )
@SpringBootTest
public class TestRedis {

    @Autowired
    @Qualifier( "redisTemplate" )
    protected RedisTemplate<String, String> redis;

    @Test
    public void test_keys() {
        String key1 = "jwt:zxf:001";
        String key2 = "jwt:zxf:002";

        this.setKV( key1, "test-01" );
        this.setKV( key2, "test-02" );

        Set<String> keys = this.keys( "jwt:zxf:" );
        log.info( "keys: {}", keys );

        this.expire( key1 );
        this.expire( key2 );
    }

    private Set<String> keys( String prefix ) {
        return redis.keys( prefix + "*" );
    }

    private void expire( String key ) {
        redis.expire( key, 0, TimeUnit.SECONDS );
    }

    private void setKV( String key, String value ) {
        redis.opsForValue()
                .set( key, value );
        redis.expire( key, 30, TimeUnit.SECONDS );
    }

}
