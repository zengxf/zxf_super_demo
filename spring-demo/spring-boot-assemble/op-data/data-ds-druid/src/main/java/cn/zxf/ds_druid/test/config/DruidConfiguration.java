package cn.zxf.ds_druid.test.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

// @Configuration
public class DruidConfiguration {

    @Bean
    public ServletRegistrationBean DruidStatViewServle2() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean( new StatViewServlet(), "/druid/*" );
        // 添加初始化参数：initParams
        servletRegistrationBean.addInitParameter( "allow", "127.0.0.1" ); // 白名单
        servletRegistrationBean.addInitParameter( "loginUsername", "admin" ); // 登录查看信息的账号密码.
        servletRegistrationBean.addInitParameter( "loginPassword", "admin" );
        servletRegistrationBean.addInitParameter( "resetEnable", "false" ); // 是否能够重置数据.
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean druidStatFilter2() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean( new WebStatFilter() );
        filterRegistrationBean.addUrlPatterns( "/*" );// 添加过滤规则.
        filterRegistrationBean.addInitParameter( "exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*" );// 添加不需要忽略的格式信息.
        return filterRegistrationBean;
    }

}
