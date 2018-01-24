package cn.zxf.mock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 参数启动
 * 
 * <pre>
 * --spring.profiles.active=test
 * </pre>
 * 
 * <p>
 * Created by zengxf on 2018-01-24
 */
@SpringBootApplication
public class MockApplication {

    public static void main( String[] args ) {
        SpringApplication.run( MockApplication.class, args );
    }

}
