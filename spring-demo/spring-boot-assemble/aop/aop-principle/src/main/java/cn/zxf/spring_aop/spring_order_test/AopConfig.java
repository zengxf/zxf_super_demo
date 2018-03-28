package cn.zxf.spring_aop.spring_order_test;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan( "cn.zxf.spring_aop.spring_order_test" )
@EnableAspectJAutoProxy
public class AopConfig {

}
