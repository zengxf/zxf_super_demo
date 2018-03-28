package cn.zxf.spring_aop.spring_order_test;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order( 2 ) // 大的在后
@Aspect
@Component
public class AopAspect2 {

    @Around( "@annotation(action)" )
    public void around( ProceedingJoinPoint pjp, Action action ) throws Throwable {
        System.out.println( "[Aspect-2] around advise 1" );
        pjp.proceed();
        System.out.println( "[Aspect-2] around advise2" );
    }

    @Before( "@annotation(action)" )
    public void before( JoinPoint joinPoint, Action action ) {
        System.out.println( "[Aspect-2] before advise" );
    }

    @After( "@annotation(action)" )
    public void after( JoinPoint joinPoint, Action action ) {
        System.out.println( "[Aspect-2] after advise" );
    }

    @AfterReturning( value = "@annotation(action)", returning = "res" )
    public void afterReturning( JoinPoint joinPoint, Action action, Object res ) {
        System.out.println( "[Aspect-2] afterReturning advise ==> return.res: " + res );
    }

    @AfterThrowing( value = "@annotation(action)", throwing = "ex" )
    public void afterThrowing( JoinPoint joinPoint, Action action, Exception ex ) {
        System.out.println( "[Aspect-2] afterThrowing advise ==> ex.msg：" + ex.getMessage() );
    }

}
