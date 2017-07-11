package cn.zxf.unit_test.user;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import cn.zxf.unit_test.AbstractApplicationTest;

public class UserControllerTest extends AbstractApplicationTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc		  mockMvc;
    private RestTemplate	  restTemplate = new RestTemplateBuilder().build();

    @Before
    public void setupMockMvc() {
	mockMvc = MockMvcBuilders.webAppContextSetup( context ).build();
    }

    @Test
    public void findAll_view() {
	String url = "http://localhost:" + port + "/api/user/find-all";
	super.info( "url: {}", url );
	List<?> list = restTemplate.getForObject( url, List.class );
	super.info( "user list: {}", list );
    }

    @Test
    public void findAll_assert() throws Exception {
	mockMvc.perform( get( "/api/user/find-all" ) //
	        .accept( MediaType.APPLICATION_JSON_UTF8 ) ) //
	        .andExpect( status().isOk() ) //
	        .andExpect( content().string( containsString( "zxf" ) ) ) //
	        .andExpect( jsonPath( "$[0].name" ).value( "zxf" ) );
    }
}
