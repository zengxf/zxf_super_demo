package cn.zxf.test.initialize.simulation_implementation;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import cn.zxf.test.initialize.person.Person;

/*** 测试 XML 读取 */
public class TestXmlReader {

    public static void main( String[] args ) {
        // 通常为BeanDefinitionRegistry的实现类，这里以DeFaultListabeBeanFactory为例
        BeanDefinitionRegistry beanRegistry = new DefaultListableBeanFactory();
        // XmlBeanDefinitionReader实现了BeanDefinitionReader接口，用于解析XML文件
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader( beanRegistry );
        // 加载配置文件
        beanDefinitionReader.loadBeanDefinitions( "classpath:applicationContext.xml" );

        // 从容器中获取bean实例
        BeanFactory container = (BeanFactory) beanRegistry;
        Person business = (Person) container.getBean( "person1" );
        System.out.println( business );
    }

}
