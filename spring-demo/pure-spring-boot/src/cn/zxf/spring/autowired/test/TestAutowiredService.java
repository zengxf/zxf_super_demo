package cn.zxf.spring.autowired.test;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class TestAutowiredService {

    public void testOut() {
	System.out.println( "test out" );
    }

    @FunctionalInterface
    public static interface Fun {
	void test();
    }

    // @Bean 与 lambda 结合，bean name 为方法名
    @Bean
    public Fun test() {
	return () -> {
	    this.testOut();
	    System.out.println( "test" );
	};
    }

    @Bean
    public Fun test1() {
	return () -> {
	    System.out.println( "test - > 1" );
	};
    }

    @Component
    public static class StaticTest1Service {

	// 根据字段名填充
	@Autowired
	private Fun		 test;
	@Autowired
	private Fun		 test1;

	// 会自动组装成 Map 和 List
	@Autowired
	private Map<String, Fun> funMap;
	@Autowired
	private List<Fun>	 funList;

	@PostConstruct
	public void init() {
	    log.info( "" );
	    log.info( "" );
	    test.test();
	    test1.test();
	    log.info( "StaticTest1Service init ------------> funMap: {}", funMap );
	    log.info( "StaticTest1Service init ------------> funList: {}", funList );
	    log.info( "StaticTest1Service init ------------> " + test );
	    log.info( "StaticTest1Service init ------------> " + test.getClass() );
	    log.info( "StaticTest1Service init ------------> " + test1 );
	    log.info( "" );
	    log.info( "" );
	}

    }

}
