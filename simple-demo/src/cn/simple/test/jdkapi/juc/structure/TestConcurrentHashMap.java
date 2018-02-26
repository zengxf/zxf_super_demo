package cn.simple.test.jdkapi.juc.structure;

import java.util.concurrent.ConcurrentHashMap;

public class TestConcurrentHashMap {

    public static void main( String[] args ) {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put( "a", "" );
        map.get( "a" );
    }

}
