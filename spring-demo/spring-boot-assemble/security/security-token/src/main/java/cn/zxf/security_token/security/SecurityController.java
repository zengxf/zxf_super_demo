package cn.zxf.security_token.security;

import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.zxf.security_token.user.User;
import cn.zxf.security_token.user.UserRepository;

@RestController
@RequestMapping( "/api/security" )
public class SecurityController {

    @Autowired
    private UserRepository repos;

    @PostMapping( "login" )
    public Map<String, Object> login( @RequestBody Map<String, String> map ) {
        String account = map.get( "account" );
        String password = map.get( "password" );
        if ( account == null || password == null )
            return Map.of( "login", "error" );

        User user = repos.login( account );
        if ( user == null )
            return Map.of( "login", "error" );

        if ( !Objects.equals( user.loginPassword(), SecretUtils.encrypt( password ) ) )
            return Map.of( "login", "error" );

        String token = TokenUtils.generate( user.id() );
        return Map.of( "login", "ok", "token", token );
    }

}
