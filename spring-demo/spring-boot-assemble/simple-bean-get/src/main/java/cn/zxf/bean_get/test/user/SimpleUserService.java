package cn.zxf.bean_get.test.user;

import org.springframework.stereotype.Component;

@Component
public class SimpleUserService extends AbstractUserService {

    public SimpleUserService() {
        super( "simple-user" );
    }

}
