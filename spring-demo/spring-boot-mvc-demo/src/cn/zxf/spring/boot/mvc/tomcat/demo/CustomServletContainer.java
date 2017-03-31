package cn.zxf.spring.boot.mvc.tomcat.demo;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.stereotype.Component;

@Component
public class CustomServletContainer implements EmbeddedServletContainerCustomizer {

    @Override
    public void customize( ConfigurableEmbeddedServletContainer container ) {
	// container.setPort( 8888 );
	// container.setSessionTimeout( 10, TimeUnit.MINUTES );
    }

}
