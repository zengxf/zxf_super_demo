package cn.zxf.spring_aop.java_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MyInvocationHandler implements InvocationHandler {

    private final IUserService service;

    @Override
    public Object invoke( Object proxy, Method method, Object[] args ) throws Throwable {
        System.out.println( "进入 proxy !!! ==> proxy: " + proxy.getClass() ); // toString() 会死循环调用
        Object result = method.invoke( service, args );
        System.out.println( "proxy-result: " + result );
        return result;
    }

}
