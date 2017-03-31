package cn.zxf.spring.small.function.aop.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main( String[] args ) {
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext( AopConfig.class ); // 1

	DemoAnnotationService demoAnnotationService = context.getBean( DemoAnnotationService.class );

	DemoMethodService demoMethodService = context.getBean( DemoMethodService.class );

	demoAnnotationService.add();

	demoMethodService.add();

	context.close();
    }

}
