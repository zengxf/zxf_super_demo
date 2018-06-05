package cn.zxf.bean_get.test.user;

import org.springframework.stereotype.Component;

@Component
public class ComplexUserService extends AbstractUserService {

    public ComplexUserService() {
        super( "complex-user" );
    }

}
