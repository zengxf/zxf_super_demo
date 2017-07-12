package cn.zxf.unit_test.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.zxf.unit_test.user.dto.UserDto;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping( "/api/user" )
@Slf4j
public class UserController {

    @Autowired
    private UserService service;

    /**
     * /api/user/find-all
     * 
     * @return
     */
    @GetMapping( "find-all" )
    public List<UserDto> findAll() {
	return service.findAll();
    }

    /**
     * /api/user/find-one
     * 
     * @return
     */

    @GetMapping( "find-one" )
    public UserDto findOne() {
	return service.findAll().get( 0 );
    }

    /**
     * /api/user/save
     * 
     * @param user
     */
    @PostMapping( "save" )
    public String save( //
            @RequestBody UserDto user //
    ) {
	log.info( "save user: {}", user );
	return "ok";
    }

    /**
     * /api/user/login
     * 
     * @return
     */
    @GetMapping( "login" )
    public String login( //
            HttpServletRequest request //
    ) {
	log.info( "session-attr: {}", request.getSession().getAttribute( "login" ) );
	log.info( "param -> username: {}, password: {}" //
	        , request.getParameter( "username" ) //
	        , request.getParameter( "password" ) );
	log.info( "request-attr: {}", request.getAttribute( "user-name" ) );
	return "ok";
    }

}
