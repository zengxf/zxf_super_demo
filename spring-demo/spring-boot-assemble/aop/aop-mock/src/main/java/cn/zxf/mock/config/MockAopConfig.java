package cn.zxf.mock.config;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import cn.zxf.mock.common.mock.DevelopMock;
import cn.zxf.mock.common.mock.MockGenericTypeOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * mock AOP configuration
 * <p>
 * 只在 dev, test 下启用，且当方法返回为 null 时才生成模拟对象
 * 
 * <p>
 * Created by zengxf on 2018-01-24
 */
@Slf4j
@Configuration
@EnableAspectJAutoProxy
@Profile( value = { "dev", "test" } )
public class MockAopConfig {

    @Aspect
    @Component
    @Profile( value = { "dev", "test" } )
    public static class MockAspect {

        @Around( value = "@annotation(developMock)" )
        public Object handle( ProceedingJoinPoint point, DevelopMock developMock ) {
            MethodSignature signature = (MethodSignature) point.getSignature();
            Method method = signature.getMethod();
            Object result = null;
            try {
                result = point.proceed();
            } catch ( Throwable e ) {
                log.info( "MockAop error: {}", e );
            }
            if ( result == null ) {
                log.info( "-------------------" );
                Type returnType = method.getGenericReturnType();
                log.info( "return-type: {}", returnType );
                result = MockGenericTypeOperation.of( returnType ) //
                        .collectionSize( developMock.collectionSize() ) //
                        .newInstance();
                log.info( "result: {}", result );
            }
            return result;
        }

    } // Aspect end

}
