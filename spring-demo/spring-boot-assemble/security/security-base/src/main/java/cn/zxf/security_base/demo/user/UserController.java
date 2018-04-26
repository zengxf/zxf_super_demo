package cn.zxf.security_base.demo.user;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping( "/api/user" )
public class UserController {

    @GetMapping( "one" )
    public String one() {
        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();
        log.info( "current-user: {}", auth.getPrincipal() );
        log.info( "current-user: {}", auth.getCredentials() );
        log.info( "current-user: {}", auth.getDetails() );
        log.info( "current-user: {}", auth.getAuthorities() );
        return "ok";
    }

}
