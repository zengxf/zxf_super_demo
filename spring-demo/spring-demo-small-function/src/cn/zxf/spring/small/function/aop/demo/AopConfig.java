package cn.zxf.spring.small.function.aop.demo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("cn.zxf.spring.small.function.aop.demo")
@EnableAspectJAutoProxy //1
public class AopConfig {

}
