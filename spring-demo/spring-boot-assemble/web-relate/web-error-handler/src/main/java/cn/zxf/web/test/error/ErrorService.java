package cn.zxf.web.test.error;

import org.springframework.stereotype.Component;

import cn.zxf.web.test.common.auth_exception.AuthException;
import cn.zxf.web.test.common.service_exception.ServiceException;

@Component
public class ErrorService {

    public void testFindOne() {
        System.out.println( "---------- testFindOne ------------" );
        throw new ServiceException( "test-error" );
    }

    public void testAuthError( String userId ) {
        System.out.println( "---------- testAuthError ------------" );
        if ( userId == null || userId.length() < 2 )
            throw new AuthException( "用户 ID 为空或错误" );
    }

    public void testCreate( FormDto dto ) {
        System.out.println( "---------- testCreate ------------" );
        System.out.println( "dto: " + dto );
    }

}
