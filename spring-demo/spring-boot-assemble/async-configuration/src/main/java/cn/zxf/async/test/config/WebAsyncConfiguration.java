package cn.zxf.async.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.context.request.async.TimeoutCallableProcessingInterceptor;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebAsyncConfiguration extends WebMvcConfigurationSupport {

    @Override
    public void configureAsyncSupport( AsyncSupportConfigurer configurer ) {
        configurer.setDefaultTimeout( 60 * 1000L );
        configurer.registerCallableInterceptors( timeoutInterceptor() );
        configurer.setTaskExecutor( threadPoolTaskExecutor() );
    }

    @Bean
    public TimeoutCallableProcessingInterceptor timeoutInterceptor() {
        return new TimeoutCallableProcessingInterceptor();
    }

    @Bean
    public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor t = new ThreadPoolTaskExecutor();
        t.setCorePoolSize( 10 );
        t.setMaxPoolSize( 50 );
        t.setThreadNamePrefix( "web-test-" );
        return t;
    }

}
