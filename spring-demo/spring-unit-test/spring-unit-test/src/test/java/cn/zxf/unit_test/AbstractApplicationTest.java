package cn.zxf.unit_test;

import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;

import org.junit.Before;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@RunWith( SpringRunner.class )
@SpringBootTest(
// classes = UnitTestApplication.class
)
@AutoConfigureMockMvc
@Slf4j
public abstract class AbstractApplicationTest {

    protected ObjectMapper		     mapper	       = new ObjectMapper();

    @Rule
    public JUnitRestDocumentation	     restDocumentation = new JUnitRestDocumentation();
    protected RestDocumentationResultHandler documentationHandler;
    // 可能用 @AutoConfigureMockMvc 和 @Autowired 自动配置
    protected MockMvc			     mockMvc;

    @Autowired
    protected WebApplicationContext	     context;

    @Before
    public void setupMockMvc() {
	this.documentationHandler = MockMvcRestDocumentation.document( "{method-name}", //
	        preprocessRequest( prettyPrint() ), //
	        preprocessResponse( prettyPrint() ) );

	this.mockMvc = MockMvcBuilders.webAppContextSetup( this.context )//
	        .apply( MockMvcRestDocumentation.documentationConfiguration( this.restDocumentation ) ) //
	        .alwaysDo( this.documentationHandler ) //
	        .build();
    }

    public String toJson( Object obj ) throws JsonProcessingException {
	return mapper.writeValueAsString( obj );
    }

    public void info( String format, Object... arguments ) {
	System.out.println();
	System.out.println();
	log.info( format, arguments );
	System.out.println();
	System.out.println();
    }

}
