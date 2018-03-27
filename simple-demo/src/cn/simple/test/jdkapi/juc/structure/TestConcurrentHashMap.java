package cn.simple.test.jdkapi.juc.structure;

import java.util.concurrent.ConcurrentHashMap;

/**
 * key 不能为 null
 * 
 * <p>
 * Created by zengxf on 2018-03-06
 */
public class TestConcurrentHashMap {

    public static void main( String[] args ) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        map.put( "a", 1 );
        map.put( "b", 2 );
        map.put( "d", 4 );
        map.put( "c", 3 );
        System.out.println( map.get( "a" ) );
        System.out.println( map.get( "b" ) );
        System.out.println( map.get( "c" ) );
        System.out.println( map.get( "d" ) );
        System.out.println( map );
        System.out.println( map.size() );
    }

}