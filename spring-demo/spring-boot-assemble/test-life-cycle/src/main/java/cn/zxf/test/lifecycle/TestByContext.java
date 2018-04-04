package cn.zxf.test.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestByContext {
    public static void main( String[] args ) {
        System.out.println( "开始初始化容器" );
        ApplicationContext ac = new ClassPathXmlApplicationContext( "classpath:applicationContext.xml" );
        System.out.println( "xml加载完毕" );

        Person person1 = (Person) ac.getBean( "person1" );
        System.out.println( "getBean: " + person1 );
        System.out.println( "关闭容器" );
        ( (ClassPathXmlApplicationContext) ac ).close();
    }

}
