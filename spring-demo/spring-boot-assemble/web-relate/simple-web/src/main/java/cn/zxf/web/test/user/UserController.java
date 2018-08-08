package cn.zxf.web.test.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Scope( "prototype" )
@RestController
@RequestMapping( value = "/users" )
public class UserController {

    @Autowired
    private UserService ser;

    @GetMapping( "/get-one" )
    public User getUser() {
        System.out.println( "-- UserController: " + this );
        return ser.getUser();
    }

}