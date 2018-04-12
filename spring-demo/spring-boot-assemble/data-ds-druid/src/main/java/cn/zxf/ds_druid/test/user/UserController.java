package cn.zxf.ds_druid.test.user;

import java.util.List;

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

    @GetMapping( "/createBySql/{name}" )
    public Long createBySql( @PathVariable String name ) {
        System.out.println( "createBySql" );
        return ser.createBySql( name );
    }

    @GetMapping( "/createByDirectSql/{name}" )
    public Long createByDirectSql( @PathVariable String name ) {
        System.out.println( "createByDirectSql" );
        return ser.createByDirectSql( name );
    }

    @GetMapping( "/executeIllegalSql" )
    public String executeIllegalSql() {
        System.out.println( "executeIllegalSql" );
        return ser.executeIllegalSql();
    }
    @GetMapping( "/executeMultiSql" )
    public String executeMultiSql() {
        System.out.println( "executeMultiSql" );
        return ser.executeMultiSql();
    }

    @GetMapping( "/findAll" )
    public List<User> findAll() {
        System.out.println( "findAll" );
        return ser.findAll();
    }

}