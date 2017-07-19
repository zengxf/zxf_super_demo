package cn.zxf.redis.demo.biz.user;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping( "/get-user-by-name" )
    public User getUserByName( @RequestParam String name ) {
	User user = service.getUserByName( name );
	return user;
    }

    @GetMapping( "/update-user-by-name" )
    public void updateUserByName( @RequestParam String name ) {
	service.updateUserByName( name );
    }

    // ---------------
    // ---------------
    // ---------------

    @GetMapping( "/session-uuid" )
    public String sessionUuid( HttpSession session ) {
	UUID uuid = (UUID) session.getAttribute( "uid" );
	if ( uuid == null ) {
	    uuid = UUID.randomUUID();
	}
	session.setAttribute( "uid", uuid );
	session.setAttribute( "random-num", Math.random() );
	return session.getId();
    }

    @GetMapping( "/session-info" )
    public Map<String, Object> sessionInfo( HttpSession session ) {
	Enumeration<String> names = session.getAttributeNames();
	Map<String, Object> map = new HashMap<>();
	while ( names.hasMoreElements() ) {
	    String name = names.nextElement();
	    map.put( name, session.getAttribute( name ) );
	}
	return map;
    }

}
