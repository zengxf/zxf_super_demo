package cn.zxf.spring.boot.mvc.junit.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.zxf.spring.boot.mvc.junit.demo.dao.PersonRepository;
import lombok.extern.slf4j.Slf4j;

@RunWith( SpringJUnit4ClassRunner.class )
@SpringBootTest( classes = Ch104Application.class ) // 1
@Slf4j
public class Ch104ApplicationTests {
    @Autowired
    PersonRepository	  personRepository;

    MockMvc		  mvc;

    @Autowired
    WebApplicationContext webApplicationContext;

    String		  expectedJson;

    @Before // 3
    public void setUp() throws JsonProcessingException {
	expectedJson = Obj2Json( personRepository.findAll() ); // 4
	mvc = MockMvcBuilders.webAppContextSetup( webApplicationContext ).build();
    }

    protected String Obj2Json( Object obj ) throws JsonProcessingException {// 5
	ObjectMapper mapper = new ObjectMapper();
	return mapper.writeValueAsString( obj );
    }

    @Test
    public void testPersonController() throws Exception {
	String uri = "/person";
	MvcResult result = mvc.perform( MockMvcRequestBuilders.get( uri ).accept( MediaType.APPLICATION_JSON ) ) //
	        .andReturn(); // 6
	int status = result.getResponse().getStatus(); // 7
	String content = result.getResponse().getContentAsString(); // 8

	log.info( "status: {}", status ); // 9
	log.info( "content: {}", content ); // 10
	log.info( "expectedJson: {}", expectedJson ); // 10
    }

}
