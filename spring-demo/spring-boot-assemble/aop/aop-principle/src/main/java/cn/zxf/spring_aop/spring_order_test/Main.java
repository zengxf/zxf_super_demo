package cn.zxf.spring_aop.spring_order_test;

import java.io.IOException;
import java.net.URISyntaxException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main( String[] args ) throws URISyntaxException, IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext( AopConfig.class ); // 1

        DemoService service = context.getBean( DemoService.class );

        System.out.println( "----------------------" );
        service.add();
        
        System.out.println( "----------------------" );
        System.out.println( "----------------------" );
        service.update( "zxf-01", "zxf-feng" );
        
        System.out.println( "----------------------" );
        System.out.println( "----------------------" );
        try {
            service.error();
        } catch ( Exception e ) {
        }
        
        System.out.println( "----------------------" );
        context.close();
    }

}
