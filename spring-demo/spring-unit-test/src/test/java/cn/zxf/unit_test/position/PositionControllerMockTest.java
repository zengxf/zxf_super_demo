package cn.zxf.unit_test.position;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import cn.zxf.unit_test.AbstractApplicationTest;
import cn.zxf.unit_test.position.dto.PositionDto;

/**
 * mock DAO，{@link PositionController}
 * 
 * <p>
 * Created by zxf on 2017-07-13
 */
// @Ignore
public class PositionControllerMockTest extends AbstractApplicationTest {

    @MockBean
    private PositionMongoDao dao;

    @Test
    public void insert() throws Exception {
	PositionDto dto = PositionDto.builder() //
	        .name( "test-1" )//
	        .status( 0 )//
	        .build();
	String json = super.toJson( dto );

	{ // mock dao
	    when( this.dao.insert( any() ) ).thenReturn( new Position( "abcabc", "test", 1 ) );
	}

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
    public void save() throws Exception {
	PositionDto dto = PositionDto.builder() //
	        .name( "test-1" )//
	        .status( 0 )//
	        .build();
	String json = super.toJson( dto );

	{ // mock dao
	    doAnswer( inv -> {
		Position pos = inv.getArgumentAt( 0, Position.class );
		super.info( "mock dao pos: {}", pos );
		return null;
	    } ).when( this.dao ).save( any() );
	}

	mockMvc.perform( post( "/api/position/save" ) //
	        .contentType( MediaType.APPLICATION_JSON_UTF8 ) //
	        .content( json ) //
	        .accept( MediaType.APPLICATION_JSON_UTF8 ) ) //
	        //
	        .andExpect( status().isOk() ) //
	        .andReturn().getResponse().getContentAsString() //
	;
    }

    @Test
    public void findAll() throws Exception {
	{ // mock dao
	    List<Position> list = new ArrayList<>();
	    list.add( new Position( "abcabc", "test", 1 ) );
	    when( this.dao.findAll() ).thenReturn( list );
	}

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
