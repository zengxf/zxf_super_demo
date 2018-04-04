package cn.zxf.test.lifecycle;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import lombok.Data;

@Data
public class Person implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {

    private String name;

    public Person() {
        System.out.println( "Person()类构造方法" );
    }

    public void setName( String name ) {
        this.name = name;
        System.out.println( "setName()方法被调用" );
    }

    // 自定义的初始化函数
    public void myInit() {
        System.out.println( "myInit()被调用" );
    }

    // 不会调用
    @PostConstruct
    public void myPostConstruct() {
        System.out.println( "myPostConstruct()被调用" );
    }

    // 自定义的销毁方法
    public void myDestroy() {
        System.out.println( "myDestroy()被调用" );
    }

    public void destroy() throws Exception {
        System.out.println( "DisposableBean.destory()被调用" );
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println( "InitializingBean.afterPropertiesSet()被调用" );
    }

    public void setApplicationContext( ApplicationContext applicationContext ) throws BeansException {
        System.out.println( "ApplicationContextAware.setApplicationContext()被调用" );
    }

    public void setBeanFactory( BeanFactory beanFactory ) throws BeansException {
        System.out.println( "BeanFactoryAware.setBeanFactory()被调用" );
    }

    public void setBeanName( String beanName ) {
        System.out.println( "BeanNameAware.setBeanName()被调用" );
    }

}