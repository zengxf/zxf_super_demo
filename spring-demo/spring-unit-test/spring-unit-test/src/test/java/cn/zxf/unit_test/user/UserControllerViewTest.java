package cn.zxf.unit_test.user;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import cn.zxf.unit_test.AbstractApplicationTest;

/**
 * {@link UserController}
 * 
 * <p>
 * Created by zxf on 2017-07-11
 */
@Ignore // 忽略 view，因为要启动 application
public class UserControllerViewTest extends AbstractApplicationTest {

    protected RestTemplate restTemplate	= new RestTemplateBuilder().build();
    protected int	   port		= 8088;

    @Test
    public void findAll() {
	String url = "http://localhost:" + port + "/api/user/find-all";
	super.info( "url: {}", url );
	List<?> list = restTemplate.getForObject( url, List.class );
	super.info( "user list: {}", list );
    }

    @Test
    public void login() throws Exception {
	String url = "http://localhost:" + port + "/api/user/login";
	super.info( "url: {}", url );
	String result = restTemplate.getForObject( url, String.class );
	super.info( "user list: {}", result );
    }

}
