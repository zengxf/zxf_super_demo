package cn.zxf.unit_test.user;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.restdocs.headers.HeaderDocumentation.headerWithName;
import static org.springframework.restdocs.headers.HeaderDocumentation.responseHeaders;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.http.MediaType;

import cn.zxf.unit_test.AbstractApplicationTest;

/**
 * {@link UserController}
 * 
 * <p>
 * Created by zxf on 2017-07-11
 */
public class UserControllerTest extends AbstractApplicationTest {

    @Test
    public void findAll_assert() throws Exception {
	mockMvc.perform( get( "/api/user/find-all" ) //
	        .accept( MediaType.APPLICATION_JSON_UTF8 ) ) //
	        .andExpect( status().isOk() ) //
	        .andExpect( content().string( containsString( "zxf" ) ) ) //
	        .andExpect( jsonPath( "$[0].name" ).value( "zxf" ) ) //
	        .andDo( this.documentationHandler.document( //
	                responseHeaders( //
	                        headerWithName( "Content-Type" ).description( "find-all 测试 ok" ) ) //
	) //
	);
    }

    @Test
    public void findOne_assert() throws Exception {
	mockMvc.perform( get( "/api/user/find-one" ) //
	        .accept( MediaType.APPLICATION_JSON_UTF8 ) ) //
	        .andExpect( status().isOk() ) //
	        .andExpect( content().string( containsString( "zxf" ) ) ) //
	        .andExpect( jsonPath( "name" ).value( "zxf" ) ) //
	        .andDo( this.documentationHandler.document( //
	                responseHeaders( //
	                        headerWithName( "Content-Type" ).description( "find-all 测试 ok" ) ), //
	                responseFields( //
	                        fieldWithPath( "name" ).description( "名称 ok" ), //
	                        fieldWithPath( "age" ).description( "年龄 ok" ), //
	                        fieldWithPath( "status" ).description( "状态 ok" ) //
			) //
	) );
    }

    @Test
    public void login_assert() throws Exception {
	session.setAttribute( "login", "ok" );
	request.setAttribute( "test", "fuck" );
	request.addParameter( "username", "zxf" );
	request.addParameter( "password", "admin" );
	mockMvc.perform( get( "/api/user/login" ) //
	        .accept( MediaType.APPLICATION_JSON_UTF8 ) ) //
	        .andExpect( status().isOk() ) //
	        .andExpect( content().string( containsString( "ok" ) ) ) //
	        .andDo( this.documentationHandler.document( //
	                responseHeaders( //
	                        headerWithName( "Content-Type" ).description( "login 测试 ok" ) ) ) );
    }
}
