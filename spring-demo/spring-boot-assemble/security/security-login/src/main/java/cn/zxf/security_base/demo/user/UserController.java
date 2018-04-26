package cn.zxf.security_base.demo.user;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping( "/ui/user" )
public class UserController {

    @GetMapping( "test" )
    public String test( HttpServletRequest request ) {
        log.info( "user: {}", request.getRemoteUser() );
        log.info( "user-principal: {}", request.getUserPrincipal() );
        log.info( "user-role-is-USER: {}", request.isUserInRole( "USER" ) );
        try {
            request.logout();
        } catch ( ServletException e ) {
            e.printStackTrace();
        }
        return "home";
    }

    @GetMapping( "login" )
    public String login( HttpServletRequest request ) {
        log.info( "user: {}", request.getRemoteUser() );
        log.info( "user-principal: {}", request.getUserPrincipal() );
        log.info( "user-role-is-USER: {}", request.isUserInRole( "USER" ) );
        try {
            request.login( "zxf", "abc" );
        } catch ( ServletException e ) {
            e.printStackTrace();
        }
        return "home";
    }

}
