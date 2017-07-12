package cn.zxf.unit_test;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;

import org.junit.Before;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.slf4j.Slf4j;

@RunWith( SpringJUnit4ClassRunner.class )
@SpringBootTest( classes = UnitTestApplication.class )
@Slf4j
public abstract class AbstractApplicationTest {

    protected RestTemplate		     restTemplate      = new RestTemplateBuilder().build();
    protected int			     port	       = 8088;

    @Rule
    public JUnitRestDocumentation	     restDocumentation = new JUnitRestDocumentation();
    protected RestDocumentationResultHandler documentationHandler;
    protected MockMvc			     mockMvc;

    @Autowired
    protected MockHttpServletRequest	     request;
    @Autowired
    protected MockHttpSession		     session;
    @Autowired
    protected WebApplicationContext	     context;

    @Before
    public void setupMockMvc() {
	this.documentationHandler = document( "{method-name}", //
	        preprocessRequest( prettyPrint() ), //
	        preprocessResponse( prettyPrint() ) );

	this.mockMvc = MockMvcBuilders.webAppContextSetup( this.context )//
	        .apply( MockMvcRestDocumentation.documentationConfiguration( this.restDocumentation ) ) //
	        .alwaysDo( this.documentationHandler ) //
	        .build();
    }

    public void info( String format, Object... arguments ) {
	System.out.println();
	System.out.println();
	log.info( format, arguments );
	System.out.println();
	System.out.println();
    }

}
