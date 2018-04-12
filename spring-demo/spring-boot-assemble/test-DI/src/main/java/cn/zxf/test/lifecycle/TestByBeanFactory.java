package cn.zxf.test.lifecycle;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

@SuppressWarnings( "deprecation" )
public class TestByBeanFactory {

    public static void main( String[] args ) {
        System.out.println( "开始初始化容器" );
        ConfigurableBeanFactory bf = new XmlBeanFactory( new ClassPathResource( "/applicationContext.xml" ) );
        System.out.println( "xml加载完毕" );

        // beanFactory 需要手动注册 beanPostProcessor 类的方法
        bf.addBeanPostProcessor( new MyBeanPostProcessor() );
        
        System.out.println( "---------- getBean() -----------" );
        Person person1 = (Person) bf.getBean( "person1" );
        System.out.println( "getBean: " + person1 );
        
        System.out.println( "关闭容器" );
        bf.destroySingletons();
    }

}
