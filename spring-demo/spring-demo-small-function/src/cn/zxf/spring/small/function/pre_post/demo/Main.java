package cn.zxf.spring.small.function.pre_post.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main( String[] args ) {
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext( PrePostConfig.class );

	BeanWayService beanWayService = context.getBean( BeanWayService.class );
	beanWayService.getClass();
	JSR250WayService jsr250WayService = context.getBean( JSR250WayService.class );
	jsr250WayService.getClass();

	context.close();
    }

}
