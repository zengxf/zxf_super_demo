package cn.zxf.redis.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import cn.zxf.redis.demo.biz.user.User;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith( SpringRunner.class )
@SpringBootTest
public class TestRedis {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @SuppressWarnings( "rawtypes" )
    @Autowired
    private RedisTemplate       redisTemplate;

    @Test
    public void test() throws Exception {
        stringRedisTemplate.opsForValue()
                .set( "aaa", "111" );
        Assert.assertEquals( "111", stringRedisTemplate.opsForValue()
                .get( "aaa" ) );
    }

    @Test
    public void testMultiThread() throws Exception {
        String key = "kk-1";
        ExecutorService executorService = Executors.newFixedThreadPool( 1000 );
        IntStream.range( 0, 1000 )
                .forEach( i -> executorService.execute( () -> {
                    stringRedisTemplate.opsForValue()
                            .increment( key, 1 );
                } ) );
        String kk = stringRedisTemplate.opsForValue()
                .get( key );
        log.info( "[累加值结果] - [{}]", kk );
    }

    @SuppressWarnings( "unchecked" )
    @Test
    public void testObj() throws Exception {
        User user = new User( "aa@126.com", "aa", 32, 2 );
        ValueOperations<String, User> operations = redisTemplate.opsForValue();
        operations.set( "com.neox", user );
        operations.set( "com.neo.f", user, 10, TimeUnit.SECONDS );
        System.out.println( "---- set ----" );
        Thread.sleep( 2000 );
        boolean exists = redisTemplate.hasKey( "com.neo.f" );
        if ( exists ) {
            System.out.println( "exists is true" );
        } else {
            System.out.println( "exists is false" );
        }
    }

}
