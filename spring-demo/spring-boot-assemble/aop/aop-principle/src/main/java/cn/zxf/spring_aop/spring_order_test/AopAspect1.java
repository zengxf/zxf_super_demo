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

@Order( 1 ) // 小的在前
@Aspect
@Component
public class AopAspect1 {

    @Around( "@annotation(action)" )
    public void around( ProceedingJoinPoint pjp, Action action ) throws Throwable {
        System.out.println( "[Aspect-1] around advise 1" );
        pjp.proceed();
        System.out.println( "[Aspect-1] around advise2" );
    }

    @Before( "@annotation(action)" )
    public void before( JoinPoint joinPoint, Action action ) {
        System.out.println( "[Aspect-1] before advise" );
    }

    @After( "@annotation(action)" )
    public void after( JoinPoint joinPoint, Action action ) {
        System.out.println( "[Aspect-1] after advise" );
    }

    @AfterReturning( value = "@annotation(action)", returning = "res" )
    public void afterReturning( JoinPoint joinPoint, Action action, Object res ) {
        System.out.println( "[Aspect-1] afterReturning advise ==> return.res: " + res );
    }

    @AfterThrowing( value = "@annotation(action)", throwing = "ex" )
    public void afterThrowing( JoinPoint joinPoint, Action action, Exception ex ) {
        System.out.println( "[Aspect-1] afterThrowing advise ==> ex.msg：" + ex.getMessage() );
    }

}
