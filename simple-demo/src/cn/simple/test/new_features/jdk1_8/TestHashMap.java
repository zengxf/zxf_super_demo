package cn.simple.test.new_features.jdk18;

import java.util.HashMap;

public class TestHashMap {
    public static void main( String[] args ) {
	HashMap<A, Object> map = new HashMap<>();
	map.put( new A( "ab" ), 12 );
	map.put( new A( "ac" ), 13 );
	map.put( new A( "bb" ), 22 );
	System.out.println( map );
    }

    static class A {

	final String name;
	final int    hash;

	public A( String name ) {
	    super();
	    this.name = name;
	    this.hash = name.charAt( 0 );
	}

	@Override
	public int hashCode() {
	    return hash;
	}

	@Override
	public boolean equals( Object obj ) {
	    return false;
	}

	@Override
	public String toString() {
	    return "A [name=" + name + ", hash=" + hash + "]";
	}

    }
}
