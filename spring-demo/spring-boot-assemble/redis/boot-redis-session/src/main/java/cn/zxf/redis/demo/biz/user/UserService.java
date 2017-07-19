package cn.zxf.redis.demo.biz.user;

import java.util.Random;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class UserService {

    @Cacheable( value = "user-key" )
    public User getUser() {
	User user = new User( "zxf-1", "zs", 12, 2 );
	System.out.println( "若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功" );
	return user;
    }

    @Cacheable( value = "user-key-by-name", key = "'test:' + #name", unless = "#result.status == 1" ) // 插入缓存
    public User getUserByName( String name ) {
	int status = new Random().nextInt( 3 );
	User user = new User( "zxf-" + status, name, 12, status );
	log.info( "get user by name: {}, status: {}", name, status );
	return user;
    }

    @CacheEvict( value = "user-key-by-name", key = "'test:' + #name" ) // 失效缓存
    public void updateUserByName( String name ) {
	log.info( "update user by name: {}", name );
    }

}
