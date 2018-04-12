package cn.simple.test.jdkapi.reflex.introspector;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

public class TestBeanUtils {

    public static void main( String[] args ) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        UserInfo userInfo = new UserInfo();

        BeanUtils.setProperty( userInfo, "name", "peida" );
        System.out.println( userInfo );

        System.out.println( "get userName: " + BeanUtils.getProperty( userInfo, "name" ) );

        System.out.println( "\n=================\n" );

        UserErrorInfo userErrorInfo = new UserErrorInfo();

        BeanUtils.setProperty( userErrorInfo, "name", "peida" );
        System.out.println( userErrorInfo );

        System.out.println( "get userName: " + BeanUtils.getProperty( userErrorInfo, "name" ) );
    }

}
