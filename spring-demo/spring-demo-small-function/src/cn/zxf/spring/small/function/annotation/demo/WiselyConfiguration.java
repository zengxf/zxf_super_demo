package cn.zxf.spring.small.function.annotation.demo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Target( ElementType.TYPE )
@Retention( RetentionPolicy.RUNTIME )
@ComponentScan // 2
@Configuration // 1
public @interface WiselyConfiguration {

    String[] value() default {}; // 3

}
