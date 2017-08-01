package cn.zxf.unit_test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.zxf.unit_test.common.LogUtil;

// @AutoConfigureMockMvc
@RunWith( SpringRunner.class )
@SpringBootTest
@ActiveProfiles( "unit" )
public abstract class AbstractApplicationTest extends LogUtil {

    protected ObjectMapper	    mapper = new ObjectMapper();

    @Autowired
    protected WebApplicationContext context;

    public String toJson( Object obj ) throws JsonProcessingException {
	return mapper.writeValueAsString( obj );
    }

}
