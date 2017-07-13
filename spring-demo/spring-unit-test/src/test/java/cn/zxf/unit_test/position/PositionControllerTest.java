package cn.zxf.unit_test.position;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.http.MediaType;

import cn.zxf.unit_test.AbstractApplicationTest;
import cn.zxf.unit_test.position.dto.PositionDto;

/**
 * 会真正的插入到数据库，{@link PositionController}
 * 
 * <p>
 * Created by zxf on 2017-07-13
 */
public class PositionControllerTest extends AbstractApplicationTest {

    @Test
    public void insert() throws Exception {
	PositionDto dto = PositionDto.builder() //
	        .name( "test-1" )//
	        .status( 0 )//
	        .build();
	String json = super.toJson( dto );

	String res = mockMvc
	        .perform( post( "/api/position/insert" ) //
	                .contentType( MediaType.APPLICATION_JSON_UTF8 ) //
	                .content( json ) //
	                .accept( MediaType.APPLICATION_JSON_UTF8 ) ) //
	        //
	        .andExpect( status().isOk() ) //
	        .andReturn().getResponse().getContentAsString() //
	;
	super.info( "res: {}", res );
    }

    @Test
    public void findAll() throws Exception {
	String res = mockMvc
	        .perform( get( "/api/position/find-all" ) //
	                .accept( MediaType.APPLICATION_JSON_UTF8 ) ) //
	        //
	        .andExpect( status().isOk() ) //
	        .andReturn().getResponse().getContentAsString() //
	;
	super.info( "res: {}", res );
    }

}
