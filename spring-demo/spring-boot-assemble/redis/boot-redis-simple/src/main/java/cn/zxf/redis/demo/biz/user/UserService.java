package cn.zxf.redis.demo.biz.user;

import org.springframework.stereotype.Component;

@Component
public class UserService {

    public User getUser() {
        User user = new User( "zxf-1", "zs", 12, 2 );
        System.out.println( "若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功" );
        return user;
    }

}
