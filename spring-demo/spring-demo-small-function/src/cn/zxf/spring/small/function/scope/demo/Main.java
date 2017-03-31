package cn.zxf.spring.small.function.scope.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main( String[] args ) {
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext( ScopeConfig.class );
	DemoSingletonService s1 = context.getBean( DemoSingletonService.class );
	DemoSingletonService s2 = context.getBean( DemoSingletonService.class );

	DemoPrototypeService p1 = context.getBean( DemoPrototypeService.class );
	DemoPrototypeService p2 = context.getBean( DemoPrototypeService.class );

	System.out.println( "s1 eq s2 " + s1.equals( s2 ) );
	System.out.println( "p1 eq p2 " + p1.equals( p2 ) );

	context.close();
    }
}
