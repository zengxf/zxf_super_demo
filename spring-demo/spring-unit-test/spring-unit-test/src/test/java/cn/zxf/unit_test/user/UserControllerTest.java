package cn.zxf.unit_test.user;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.restdocs.headers.HeaderDocumentation.headerWithName;
import static org.springframework.restdocs.headers.HeaderDocumentation.responseHeaders;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.http.MediaType;

import cn.zxf.unit_test.AbstractApplicationTest;
import cn.zxf.unit_test.user.dto.UserDto;

/**
 * {@link UserController}
 * 
 * <p>
 * Created by zxf on 2017-07-11
 */
public class UserControllerTest extends AbstractApplicationTest {

    @Test
    public void findAll() throws Exception {
	mockMvc.perform( get( "/api/user/find-all" ) //
	        .accept( MediaType.APPLICATION_JSON_UTF8 ) ) //
	        //
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
    public void save() throws Exception {
	String json = super.toJson( new UserDto( "zxf-t1", 32, 1 ) );
	super.info( "json: {}", json );

	Object res = //
	        mockMvc.perform( post( "/api/user/save" ) //
	                .content( json ) //
	                .contentType( MediaType.APPLICATION_JSON ) //
	                .accept( MediaType.APPLICATION_JSON_UTF8 ) ) //
	                //
	                .andExpect( status().isOk() ) //
	                .andReturn().getResponse().getContentAsString() //
	;
	super.info( "res: {}", res );
    }

    @Test
    public void findOne() throws Exception {
	mockMvc.perform( get( "/api/user/find-one" ) //
	        .accept( MediaType.APPLICATION_JSON_UTF8 ) ) //
	        //
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
    public void login() throws Exception {
	mockMvc.perform( get( "/api/user/login" ) //
	        // mock request, session start
	        .with( req -> { //
	            req.addParameter( "username", "zxf" );
	            req.addParameter( "password", "admin" );
	            return req;
	        } ) //
	        .requestAttr( "user-name", "zxf-admin" ) //
	        .sessionAttr( "login", "user-zxf-id" ) //
	        // mock end
	        .accept( MediaType.APPLICATION_JSON_UTF8 ) ) //
	        .andExpect( status().isOk() ) //
	        .andExpect( content().string( containsString( "ok" ) ) ) //
	        .andDo( this.documentationHandler.document( //
	                responseHeaders( //
	                        headerWithName( "Content-Type" ).description( "login 测试 ok" ) ) ) );
    }
}
