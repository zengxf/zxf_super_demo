package cn.zxf.redis.demo.biz.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/api/user" )
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping( "/get-user" )
    public User getUser() {
        User user = service.getUser();
        return user;
    }

}
