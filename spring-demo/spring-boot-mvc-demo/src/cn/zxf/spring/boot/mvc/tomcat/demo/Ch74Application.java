package cn.zxf.spring.boot.mvc.tomcat.demo;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication( exclude = SecurityAutoConfiguration.class )
@PropertySource( "classpath:/cn/zxf/spring/boot/mvc/tomcat/demo/resources/application.properties" )
public class Ch74Application {

    public static void main( String[] args ) {
	SpringApplication.run( Ch74Application.class, args );
    }

    // @Component
    // public static class CustomServletContainer implements EmbeddedServletContainerCustomizer{
    //
    // @Override
    // public void customize(ConfigurableEmbeddedServletContainer container) {
    // container.setPort(8888);//1
    // container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404.html"));
    // container.setSessionTimeout(10,TimeUnit.MINUTES);
    // }
    //
    // }

    // @Bean
    // public EmbeddedServletContainerFactory servletContainer() {
    // TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
    // factory.setPort( 8888 );
    // factory.setSessionTimeout( 10, TimeUnit.MINUTES );
    // factory.addErrorPages( new ErrorPage( HttpStatus.NOT_FOUND, "/404.html" ) );
    // return factory;
    // }

    @Bean
    public EmbeddedServletContainerFactory servletContainer() {
	TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory() {
	    @Override
	    protected void postProcessContext( Context context ) {
		SecurityConstraint securityConstraint = new SecurityConstraint();
		securityConstraint.setUserConstraint( "CONFIDENTIAL" );
		SecurityCollection collection = new SecurityCollection();
		collection.addPattern( "/*" );
		securityConstraint.addCollection( collection );
		context.addConstraint( securityConstraint );
	    }
	};

	tomcat.addAdditionalTomcatConnectors( httpConnector() );
	return tomcat;
    }

    @Bean
    public Connector httpConnector() {
	Connector connector = new Connector( "org.apache.coyote.http11.Http11NioProtocol" );
	connector.setScheme( "http" );
	connector.setPort( 8080 );
	connector.setSecure( false );
	connector.setRedirectPort( 8443 );
	return connector;
    }
}
