package cn.zxf.redis.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * 使用 Redis Session 之后，原 Boot 的 server.session.timeout 属性不再生效
 * 
 * <p>
 * Created by zxf on 2017-07-18
 */
@Configuration
@EnableRedisHttpSession( maxInactiveIntervalInSeconds = 1800 ) // 单位：秒
public class SessionConfig {

}
