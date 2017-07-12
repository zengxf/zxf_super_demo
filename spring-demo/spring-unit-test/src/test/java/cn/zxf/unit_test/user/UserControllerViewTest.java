package cn.zxf.unit_test.user;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import cn.zxf.unit_test.AbstractApplicationTest;

/**
 * {@link UserController}
 * 
 * <p>
 * Created by zxf on 2017-07-11
 */
@Ignore // 忽略 view，因为要启动 application
public class UserControllerViewTest extends AbstractApplicationTest {

    @Test
    public void findAll_view() {
	String url = "http://localhost:" + port + "/api/user/find-all";
	super.info( "url: {}", url );
	List<?> list = super.restTemplate.getForObject( url, List.class );
	super.info( "user list: {}", list );
    }

    @Test
    public void login_view() throws Exception {
	session.setAttribute( "login", "ok" );
	request.setAttribute( "test", "fuck" );
	request.addParameter( "username", "zxf" );
	request.addParameter( "password", "admin" );
	String url = "http://localhost:" + port + "/api/user/login";
	super.info( "url: {}", url );
	String result = super.restTemplate.getForObject( url, String.class );
	super.info( "user list: {}", result );
    }

}
