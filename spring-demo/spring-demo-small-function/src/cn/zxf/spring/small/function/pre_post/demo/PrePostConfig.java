package cn.zxf.spring.small.function.pre_post.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan( "cn.zxf.spring.small.function.pre_post.demo" )
public class PrePostConfig {

    @Bean( initMethod = "init", destroyMethod = "destroy" ) // 1
    BeanWayService beanWayService() {
	return new BeanWayService();
    }

    @Bean
    JSR250WayService jsr250WayService() {
	return new JSR250WayService();
    }

}
