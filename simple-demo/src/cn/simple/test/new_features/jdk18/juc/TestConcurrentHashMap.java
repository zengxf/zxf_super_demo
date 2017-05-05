package cn.simple.test.new_features.jdk18.juc;

import java.util.concurrent.ConcurrentHashMap;

public class TestConcurrentHashMap {
    public static void main( String[] args ) {
	ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
	map.put( "foo", "bar" );
	map.put( "han", "solo" );
	map.put( "r2", "d2" );
	map.put( "c3", "p0" );

	// forEach( map );

	// search( map );

	// searchValues( map );

	reduce( map );
    }

    static void reduce( ConcurrentHashMap<String, String> map ) {
	String result = map.reduce( 1, ( key, value ) -> {
	    String v = key + "=" + value;
	    System.out.println( "Transform: " + Thread.currentThread().getName() + "\t" + v );
	    return v;
	}, ( s1, s2 ) -> {
	    String v = s1 + ", " + s2;
	    System.out.println( "Reduce: " + Thread.currentThread().getName() + "\t" + v );
	    return v;
	} );
	System.out.println( "Result: " + result );
    }

    static void searchValues( ConcurrentHashMap<String, String> map ) {
	String result = map.searchValues( 1, value -> {
	    System.out.println( Thread.currentThread().getName() );
	    if ( value.length() > 3 ) {
		return value;
	    }
	    return null;
	} );
	System.out.println( "Result: " + result );
    }

    static void search( ConcurrentHashMap<String, String> map ) {
	String result = map.search( 1, ( key, value ) -> {
	    System.out.println( Thread.currentThread().getName() );
	    if ( "foo".equals( key ) ) {
		return value;
	    }
	    return null;
	} );
	System.out.println( "Result: " + result );
    }

    static void forEach( ConcurrentHashMap<String, String> map ) {
	map.forEach( 1, ( key, value ) -> //
	System.out.printf( "key: %s; value: %s; thread: %s\n", key, value, Thread.currentThread().getName() ) );
    }
}
