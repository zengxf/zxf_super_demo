package cn.simple.test.jdkapi.reflex.introspector;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.PropertyUtils;

public class TestPropertyUtils {

    public static void main( String[] args ) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        UserInfo userInfo = new UserInfo();

        PropertyUtils.setProperty( userInfo, "name", "test" );
        System.out.println( userInfo );

        System.out.println( PropertyUtils.getProperty( userInfo, "name" ) );
    }

}
