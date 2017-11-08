package cn.test.api;

import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ServerStart implements ApplicationContextAware {
    private static ApplicationContext context;

    public static void main( String[] args ) throws Exception {

        /// 默认 dubbo.properties
        System.setProperty( "dubbo.properties.file", "application.properties" );

        context = new SpringApplicationBuilder( ServerStart.class ) //
                .sources( ServerStart.class ) //
                .properties( getProperties() ) //
                .run( args );

        System.out.println( "Start DubboTestServer Done ..." );
    }

    private static Properties getProperties() {
        Properties props = new Properties();
        props.put( "spring.config.location", "classpath" );
        return props;
    }

    public static ApplicationContext getContext() {
        return context;
    }

    @Override
    public void setApplicationContext( ApplicationContext applicationContext ) throws BeansException {
        System.out.println( "<context> Inject context" );
        context = applicationContext;
    }
}
