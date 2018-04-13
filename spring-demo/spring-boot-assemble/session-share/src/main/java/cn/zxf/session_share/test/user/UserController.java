package cn.zxf.session_share.test.user;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( value = "/users" )
public class UserController {

    @GetMapping( "login" )
    public Object login( HttpServletRequest request ) {
        request.getSession()
                .setAttribute( "username", "test-0011" );
        return request.getSession()
                .getAttribute( "username" );
    }

    @GetMapping( "show" )
    public Object show( HttpServletRequest request ) {
        return request.getSession()
                .getAttribute( "username" );
    }

}