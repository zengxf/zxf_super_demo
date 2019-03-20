package cn.zxf.jpa_transaction.test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.DebuggingClassWriter;

@SpringBootApplication
public class JpaTransactionApplication {

    public static void main( String[] args ) throws URISyntaxException, IOException {
        setSavePath();
        SpringApplication.run( JpaTransactionApplication.class, args );
    }

    static void setSavePath() throws URISyntaxException, IOException {
        Path path = Paths.get( JpaTransactionApplication.class.getResource( "/" )
                .toURI() );
        Path savePath = path.resolve( "../export/spring-aop-proxy" )
                .normalize()
                .toAbsolutePath();
        // Files.deleteIfExists( savePath );
        Files.createDirectories( savePath );

        System.out.println( "class 存放路径：" );
        System.out.println( savePath );
        System.out.println( "----------------------" );

        // 设置将 cglib 生成的代理类字节码生成到指定位置
        System.setProperty( DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, savePath.toString() );
    }
}
