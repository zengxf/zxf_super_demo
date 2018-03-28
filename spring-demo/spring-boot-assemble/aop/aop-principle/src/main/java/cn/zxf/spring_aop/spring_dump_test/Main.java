package cn.zxf.spring_aop.spring_dump_test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main( String[] args ) throws URISyntaxException, IOException {
        setSavePath();

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext( AopConfig.class ); // 1

        DemoAnnotationService demoAnnotationService = context.getBean( DemoAnnotationService.class );
        DemoMethodService demoMethodService = context.getBean( DemoMethodService.class );
        System.out.println( "----------------------" );
        demoAnnotationService.add();
        System.out.println( "----------------------" );
        demoMethodService.add();

        context.close();
    }

    static void setSavePath() throws URISyntaxException, IOException {
        Path path = Paths.get( Main.class.getResource( "/" ).toURI() );
        Path savePath = path.resolve( "../export/spring-aop-proxy" ).normalize().toAbsolutePath();
        Files.createDirectories( savePath );

        System.out.println( "class 存放路径：" );
        System.out.println( savePath );
        System.out.println( "----------------------" );

        // 设置将 cglib 生成的代理类字节码生成到指定位置
        System.setProperty( DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, savePath.toString() );
    }

}
