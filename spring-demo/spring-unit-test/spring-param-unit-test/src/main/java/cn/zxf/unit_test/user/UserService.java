package cn.zxf.unit_test.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import cn.zxf.unit_test.user.dto.UserDto;

@Component
public class UserService {

    @Value( "${test.str}" )
    private String testStr;

    public List<UserDto> findAll() {
        List<UserDto> list = new ArrayList<>();
        list.add( new UserDto( "zxf", 22, 1, testStr ) );
        list.add( new UserDto( "zxf1", 33, 2, testStr ) );
        return list;
    }

    public UserDto addUser( String name, int age, int status ) {
        return new UserDto( name, age, status, testStr );
    }

}
