package cn.zxf.jpa_transaction.test.user_log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( value = "/user-log" )
public class UserLogController {

    static final long      DEF_USER_ID = 10L;

    @Autowired
    private UserLogService ser;

    @GetMapping( "/createNonTransaction" )
    public UserLog createNonTransaction() {
        System.out.println( "无事务创建" );
        return ser.createNonTransaction( DEF_USER_ID );
    }

    @GetMapping( "/createTransactionalRequired/{sign}" )
    public UserLog createTransactionalRequired( @PathVariable String sign ) {
        System.out.println( "事务创建-Required-" + sign );
        return ser.createTransactionalRequired( DEF_USER_ID, sign );
    }

    @GetMapping( "/createTransactionalSupports/{sign}" )
    public UserLog createTransactionalSupports( @PathVariable String sign ) {
        System.out.println( "事务创建-Supports-" + sign );
        return ser.createTransactionalSupports( DEF_USER_ID, sign );
    }

    @GetMapping( "/createTransactionalMandatory/{sign}" )
    public UserLog createTransactionalMandatory( @PathVariable String sign ) {
        System.out.println( "事务创建-Mandatory-" + sign );
        return ser.createTransactionalMandatory( DEF_USER_ID, sign );
    }

    @GetMapping( "/createTransactionalRequiresNew/{sign}" )
    public UserLog createTransactionalRequiresNew( @PathVariable String sign ) {
        System.out.println( "事务创建-RequiresNew-" + sign );
        return ser.createTransactionalRequiresNew( DEF_USER_ID, sign );
    }

    @GetMapping( "/createTransactionalNotSupported/{sign}" )
    public UserLog createTransactionalNotSupported( @PathVariable String sign ) {
        System.out.println( "事务创建-NotSupported-" + sign );
        return ser.createTransactionalNotSupported( DEF_USER_ID, sign );
    }

    @GetMapping( "/createTransactionalNever/{sign}" )
    public UserLog createTransactionalNever( @PathVariable String sign ) {
        System.out.println( "事务创建-Never-" + sign );
        return ser.createTransactionalNever( DEF_USER_ID, sign );
    }

    @GetMapping( "/createTransactionalNested/{sign}" )
    public UserLog createTransactionalNested( @PathVariable String sign ) {
        System.out.println( "事务创建-Nested-" + sign );
        return ser.createTransactionalNested( DEF_USER_ID, sign );
    }

}