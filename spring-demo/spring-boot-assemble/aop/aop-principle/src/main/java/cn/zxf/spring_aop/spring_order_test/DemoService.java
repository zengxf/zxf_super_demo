package cn.zxf.spring_aop.spring_order_test;

import org.springframework.stereotype.Service;

@Service
public class DemoService {

    @Action( name = "add 操作" )
    public String add() {
        System.out.println( "entry DemoAnnotationService.add() ..." );
        return "zxf-01";
    }

    @Action( name = "update 操作" )
    public String update( String id, String name ) {
        System.out.println( "entry DemoAnnotationService.update() ... " + id + " - " + name );
        return "zxf-01";
    }

    @Action( name = "error 操作" )
    public void error() {
        System.out.println( "entry DemoAnnotationService.error() ..." );
        throw new RuntimeException( "---------------------- test error ---------------------" );
    }

}
