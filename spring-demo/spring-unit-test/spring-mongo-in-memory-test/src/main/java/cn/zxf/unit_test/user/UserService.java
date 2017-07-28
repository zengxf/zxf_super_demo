package cn.zxf.unit_test.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import cn.zxf.unit_test.user.dto.UserDto;

@Component
public class UserService {

    public List<UserDto> findAll() {
	List<UserDto> list = new ArrayList<>();
	list.add( new UserDto( "zxf", 22, 1 ) );
	list.add( new UserDto( "zxf1", 33, 2 ) );
	return list;
    }

}
