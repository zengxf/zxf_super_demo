package cn.zxf.swagger2_test.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * "/swagger-ui.html" 405 时，要配置下
 * 
 * <p>
 * Created by zengxf on 2018-04-27
 */
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers( ResourceHandlerRegistry registry ) {
        // registry.addResourceHandler( "swagger-ui.html" )
        // .addResourceLocations( "classpath:/META-INF/resources/" );
        // registry.addResourceHandler( "/webjars/**" )
        // .addResourceLocations( "classpath:/META-INF/resources/webjars/" );
    }

}
