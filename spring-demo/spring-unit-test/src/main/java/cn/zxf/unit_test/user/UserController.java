package cn.zxf.unit_test.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
     * http://localhost:8088/api/user/find-all
     * 
     * @return
     */
    @GetMapping( "find-all" )
    public List<UserDto> findAll() {
	return service.findAll();
    }

    /**
     * http://localhost:8088/api/user/find-one
     * 
     * @return
     */
    @GetMapping( "find-one" )
    public UserDto findOne() {
	return service.findAll().get( 0 );
    }

    /**
     * http://localhost:8088/api/user/login
     * 
     * @return
     */
    @GetMapping( "login" )
    public String login( //
            HttpServletRequest request //
    ) {
	request.getSession().getAttribute( "login" );
	log.info( "param -> username: {}, password: {}" //
	        , request.getParameter( "username" ) //
	        , request.getParameter( "password" ) );
	return "ok";
    }

}
