package cn.simple.test.apache.common.lang;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import lombok.Data;

public class TestBeanUtil {

    public static void main( String[] args ) throws IllegalAccessException, InvocationTargetException {
	Map<String, Object> map = new HashMap<>();
	map.put( "name", 21 );
	map.put( "age", 33 );

	User user = new User();
	BeanUtils.populate( user, map );

	System.out.println( user );

	UserDto dto = new UserDto();
	BeanUtils.copyProperties( dto, user );
	System.out.println( dto );
    }

    @Data
    public static class User {
	private String name;
	private int    age;
    }

    @Data
    public static class UserDto {
	private String name;
	private int    age;
    }

}
