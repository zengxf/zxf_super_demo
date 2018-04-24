package cn.zxf.session_share.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;

/**
 * 设置不同子域名下 cookie 共享
 * 
 * <p>
 * Created by zengxf on 2018-04-24
 */
@Configuration
public class SessionConfig {

    @Bean
    public CookieSerializer cookieSerializer() {
        DefaultCookieSerializer serializer = new DefaultCookieSerializer();
        serializer.setCookieName( "JSESSIONID" );
        serializer.setCookiePath( "/" );
        // serializer.setDomainNamePattern( "^.+?\\.(\\w+\\.[a-z]+)$" );
        serializer.setDomainNamePattern( "(127.0.0.1)|(192.168.1.161)" );
        return serializer;
    }

}
