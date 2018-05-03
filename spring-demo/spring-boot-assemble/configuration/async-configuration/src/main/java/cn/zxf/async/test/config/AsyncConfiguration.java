package cn.zxf.async.test.config;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableAsync
@Configuration
public class AsyncConfiguration {

    @Bean
    public AsyncConfigurer config() {
        return new AsyncTaskExecutePool();
    }

    static class AsyncTaskExecutePool implements AsyncConfigurer {

        @Override
        public Executor getAsyncExecutor() {
            ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
            executor.setCorePoolSize( 4 );
            executor.setMaxPoolSize( 8 );
            executor.setQueueCapacity( 10 );
            executor.setKeepAliveSeconds( 60 );
            executor.setThreadNamePrefix( "zxf-test-" );
            executor.setRejectedExecutionHandler( new ThreadPoolExecutor.CallerRunsPolicy() );
            executor.initialize();
            return executor;
        }

        @Override
        public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() { // 异步任务中异常处理
            return new AsyncUncaughtExceptionHandler() {
                @Override
                public void handleUncaughtException( Throwable ex, Method method, Object... params ) {
                    log.info( "========================== " + ex.getMessage() + " =======================", ex );
                    log.info( "======== exception method: " + method.getName() );
                }
            };
        }
    }

}
