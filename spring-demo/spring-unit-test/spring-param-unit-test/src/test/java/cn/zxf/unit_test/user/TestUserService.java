package cn.zxf.unit_test.user;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.zxf.unit_test.AbstractParamApplicationTest;
import cn.zxf.unit_test.user.dto.UserDto;
import junitparams.Parameters;

public class TestUserService extends AbstractParamApplicationTest {

    @Autowired
    private UserService service;

    @Test
    public void test_findAll() {
        service.findAll()
                .forEach( dto -> super.info( "dto: {}", dto ) );
    }

    @Test
    @Parameters( "zxfeng, 312, 0" )
    public void test_addUser1( String name, int age, int status ) throws Exception {
        UserDto dto = service.addUser( name, age, status );
        super.info( "add-dto: {}", dto );
    }

    @Test
    @Parameters( { "zxf, 32, 1", "feng, 22, 2" } )
    public void test_addUser2( String name, int age, int status ) throws Exception {
        UserDto dto = service.addUser( name, age, status );
        super.info( "add-dto: {}", dto );
    }

}
