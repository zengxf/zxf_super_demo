package cn.zxf.test.initialize.simulation_implementation;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

import cn.zxf.test.initialize.person.Person;

/** 默认容器实现，注册-实例化 */
public class TestBeanFactory {

    public static void main( String[] args ) {
        // 默认容器实现
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 根据业务对象构造相应的 BeanDefinition
        AbstractBeanDefinition definition = new RootBeanDefinition( Person.class, AutowireCapableBeanFactory.AUTOWIRE_NO, true );
        // 将 bean 定义注册到容器中
        beanFactory.registerBeanDefinition( "beanName", definition );
        // 如果有多个 bean，还可以指定各个 bean 之间的依赖关系
        // ........

        // 然后可以从容器中获取这个 bean 的实例
        Person business = (Person) beanFactory.getBean( "beanName" );
        System.out.println( business );
    }

}
