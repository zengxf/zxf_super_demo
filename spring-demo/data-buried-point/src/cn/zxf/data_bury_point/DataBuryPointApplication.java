package cn.zxf.data_bury_point;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 数据埋点应用启动类
 * 
 * <p>
 * Created by zxf on 2017-06-01
 */
@SpringBootApplication
@ServletComponentScan
@EnableAsync
public class DataBuryPointApplication {

    public static void main( String[] args ) {
	SpringApplication.run( DataBuryPointApplication.class, args );
    }

}
