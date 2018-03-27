package cn.zxf.jpa_transaction.test.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Scope( "prototype" )
@RestController
@RequestMapping( value = "/user" )
public class UserController {

    @Autowired
    private UserService ser;

    @GetMapping( "/createNonTransaction/{name}" )
    public User createNonTransaction( @PathVariable String name ) {
        System.out.println( "无事务创建" );
        return ser.createNonTransaction( name );
    }

    @GetMapping( "/createTransactionalRequired/{name}/{sign}" )
    public User createTransactionalRequired( @PathVariable String name, @PathVariable String sign ) {
        System.out.println( "事务创建-Required-" + sign );
        return ser.createTransactionalRequired( name, sign );
    }

    @GetMapping( "/createTransactionalSupports/{name}/{sign}" )
    public User createTransactionalSupports( @PathVariable String name, @PathVariable String sign ) {
        System.out.println( "事务创建-Supports-" + sign );
        return ser.createTransactionalSupports( name, sign );
    }

    @GetMapping( "/createTransactionalMandatory/{name}/{sign}" )
    public User createTransactionalMandatory( @PathVariable String name, @PathVariable String sign ) {
        System.out.println( "事务创建-Mandatory-" + sign );
        return ser.createTransactionalMandatory( name, sign );
    }

    @GetMapping( "/createTransactionalRequiresNew/{name}/{sign}" )
    public User createTransactionalRequiresNew( @PathVariable String name, @PathVariable String sign ) {
        System.out.println( "事务创建-RequiresNew-" + sign );
        return ser.createTransactionalRequiresNew( name, sign );
    }

    @GetMapping( "/createTransactionalNotSupported/{name}/{sign}" )
    public User createTransactionalNotSupported( @PathVariable String name, @PathVariable String sign ) {
        System.out.println( "事务创建-NotSupported-" + sign );
        return ser.createTransactionalNotSupported( name, sign );
    }

    @GetMapping( "/createTransactionalNever/{name}/{sign}" )
    public User createTransactionalNever( @PathVariable String name, @PathVariable String sign ) {
        System.out.println( "事务创建-Never-" + sign );
        return ser.createTransactionalNever( name, sign );
    }

    @GetMapping( "/createTransactionalNested/{name}/{sign}" )
    public User createTransactionalNested( @PathVariable String name, @PathVariable String sign ) {
        System.out.println( "事务创建-Nested-" + sign );
        return ser.createTransactionalNested( name, sign );
    }

}