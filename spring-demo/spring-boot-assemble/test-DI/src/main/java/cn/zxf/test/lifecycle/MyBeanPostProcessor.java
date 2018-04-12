package cn.zxf.test.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {

    public Object postProcessBeforeInitialization( Object bean, String beanName ) throws BeansException {
        System.out.println( "MyBeanPostProcessor.postProcessBeforeInitialization()被调用" );
        return bean;
    }

    public Object postProcessAfterInitialization( Object bean, String beanName ) throws BeansException {
        System.out.println( "MyBeanPostProcessor.postProcessAfterInitialization()被调用" );
        return bean;
    }

}
