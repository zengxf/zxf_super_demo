package cn.zxf.session_share.test.user;

import static org.springframework.session.FindByIndexNameSessionRepository.PRINCIPAL_NAME_INDEX_NAME;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.session.ExpiringSession;
import org.springframework.session.FindByIndexNameSessionRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( value = "/users" )
public class UserController {

    @Autowired
    private FindByIndexNameSessionRepository<? extends ExpiringSession> sessionRepository;

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

    @GetMapping( "cookies" )
    public Map<String, ? extends ExpiringSession> findByUsername( //
            @RequestParam String username //
    ) {
        Map<String, ? extends ExpiringSession> usersSessions = sessionRepository.findByIndexNameAndIndexValue( PRINCIPAL_NAME_INDEX_NAME, username );
        return usersSessions;
    }

}