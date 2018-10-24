package cn.zxf.redis_test;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import cn.zxf.redis_test.user.User;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith( SpringRunner.class )
@SpringBootTest
public class TestRedisApplication {

    @Autowired
    private StringRedisTemplate           stringRedisTemplate;
    @Autowired
    private RedisTemplate<String, Object> redisCacheTemplate;

    @Test
    public void test() {
        ExecutorService executorService = Executors.newFixedThreadPool( 1000 );
        IntStream.range( 0, 1000 )
                .forEach( i -> executorService.execute( () -> stringRedisTemplate.opsForValue()
                        .increment( "kk", 1 ) ) );
        String kk = stringRedisTemplate.opsForValue()
                .get( "kk" );
        log.info( "[累加值结果] - [{}]", kk );

        stringRedisTemplate.opsForValue()
                .set( "k1", "v1" );
        String k1 = stringRedisTemplate.opsForValue()
                .get( "k1" );
        log.info( "[字符缓存结果] - [{}]", k1 );

        String key = "user-1";
        redisCacheTemplate.opsForValue()
                .set( key, new User( "uid-002", new Date(), "zxf-test" ) );
        User user = (User) redisCacheTemplate.opsForValue()
                .get( key );
        log.info( "[对象缓存结果] - [{}]", user );
    }

}
