package cn.zxf.spring_aop.java_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main( String[] args ) throws URISyntaxException {
        // 生成在项目根目录下的 "com\sun\proxy" 文件下
        System.setProperty( "sun.misc.ProxyGenerator.saveGeneratedFiles", "true" ); // Java8
        // System.setProperty( "jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true" ); // Java9
        Path path = Paths.get( Main.class.getResource( "/" )
                .toURI() );
        System.out.println( "proxy class 存放路径：" );
        System.out.println( path.resolve( "../com/sun/proxy" )
                .normalize()
                .toAbsolutePath() );
        System.out.println( "----------------------" );

        test1();
        test2();
        test3();
    }

    @SuppressWarnings( { "rawtypes" } )
    static void test1() {
        IUserService service = new UserService();
        InvocationHandler handler = new MyInvocationHandler( service );
        Class[] interfaces = new Class[] { IUserService.class };
        IUserService proxy = (IUserService) Proxy.newProxyInstance( Main.class.getClassLoader(), interfaces, handler );
        String name = proxy.getUserName( "!!1" );
        System.out.println( "name: " + name );
        System.out.println( "----------------------" );
    }

    @SuppressWarnings( { "rawtypes" } )
    static void test2() {
        IUserService service = new UserService();
        InvocationHandler handler = new MyInvocationHandler( service );
        Class[] interfaces = new Class[] { ILogService.class };
        ILogService proxy = (ILogService) Proxy.newProxyInstance( Main.class.getClassLoader(), interfaces, handler );
        String name = proxy.log( "@@2" );
        System.out.println( "name: " + name );
        System.out.println( "----------------------" );
    }

    @SuppressWarnings( { "rawtypes" } )
    static void test3() {
        IUserService service = new UserService();
        InvocationHandler handler = new MyInvocationHandler( service );
        Class[] interfaces = new Class[] { IUserService.class, ILogService.class };
        Object proxy = Proxy.newProxyInstance( Main.class.getClassLoader(), interfaces, handler );
        {
            String name = ( (IUserService) proxy ).getUserName( "##3" );
            System.out.println( "name: " + name );
            System.out.println( "----------------------" );
        }
        {
            String name = ( (ILogService) proxy ).log( "$$4" );
            System.out.println( "name: " + name );
            System.out.println( "----------------------" );
        }
    }

}
