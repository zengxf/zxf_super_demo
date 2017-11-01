package cn.zxf.spring_aop.spring_test;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan( "cn.zxf.spring_aop.spring_test" )
@EnableAspectJAutoProxy // 1
// @PropertySource( "classpath:cn/zxf/spring_aop/spring_test/application.properties" ) // 7
public class AopConfig {

}
