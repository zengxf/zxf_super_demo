package cn.zxf.unit_test.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.zxf.unit_test.user.dto.UserDto;

@RestController
@RequestMapping( "/api/user" )
public class UserController {

    @Autowired
    private UserService service;

    /**
     * http://localhost:8088/api/user/find-all
     * 
     * @return
     */
    @GetMapping( "find-all" )
    public List<UserDto> findAll() {
	return service.findAll();
    }

}
