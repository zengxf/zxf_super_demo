package cn.zxf.spring.small.function.profile.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main( String[] args ) {
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

	context.getEnvironment().setActiveProfiles( "prod" ); // 1
	context.register( ProfileConfig.class );// 2
	context.refresh(); // 3

	DemoBean demoBean = context.getBean( DemoBean.class );

	System.out.println( demoBean.getContent() );

	context.close();
    }
}
