package cn.zxf.web.test.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import cn.zxf.web.test.user.UserFilter;
import cn.zxf.web.test.user.UserInterceptor;

@Configuration
@ServletComponentScan( "cn.zxf.web.test" )
public class WebConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private CommonInterceptor commonInterceptor;

    @Override
    public void addInterceptors( InterceptorRegistry registry ) {
        // registry.addInterceptor( new CommonInterceptor() ); // 内部是 ArrayList，所以按添加顺序执行
        registry.addInterceptor( commonInterceptor );
        registry.addInterceptor( new UserInterceptor() )
                .addPathPatterns( "/users/*" );
    }

    @Bean
    public FilterRegistrationBean initUserFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter( new UserFilter() );
        registration.addUrlPatterns( "/users/*" );
        registration.setOrder( 20 );
        return registration;
    }

    // @Bean
    // public FilterRegistrationBean initCommonFilter() {
    // FilterRegistrationBean registration = new FilterRegistrationBean();
    // registration.setFilter( new CommonFilter() );
    // registration.setOrder( 10 );
    // return registration;
    // }

    // @Bean
    // public ServletRegistrationBean initPositionServlet() {
    // ServletRegistrationBean registration = new ServletRegistrationBean();
    // registration.setServlet( new PositionServlet() );
    // List<String> urlMappings = new ArrayList<String>();
    // urlMappings.add( "/position-servlet" ); // 访问，可以添加多个
    // registration.setUrlMappings( urlMappings );
    // registration.setLoadOnStartup( 1 ); // >=0 设置容器启动时就加载 servlet
    // return registration;
    // }

}
