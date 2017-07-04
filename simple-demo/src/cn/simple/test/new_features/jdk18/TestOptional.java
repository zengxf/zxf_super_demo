package cn.simple.test.new_features.jdk18;

import java.util.Optional;

/**
 * 在Java 8中，不推荐你返回null而是返回Optional
 * 
 * @author zengxf
 */
public class TestOptional {
    public static void main( String[] args ) throws Throwable {
	Optional<String> optional = Optional.of( "BAM" );
	System.out.println( optional.isPresent() ); // true
	System.out.println( optional.get() ); // "BAM"
	System.out.println( optional.orElse( "fallback" ) ); // "BAM"
	optional.ifPresent( ( s ) -> System.out.println( s.charAt( 0 ) ) ); // "B"

	System.out.println( "-------------" );
	map();
	System.out.println( "-------------" );
	flatMap();
    }

    static void map() throws Throwable {
	Optional.of( new Outer() )//
	        .map( o -> o.nested )//
	        .map( n -> n.inner )//
	        .map( i -> i.foo )//
	        .ifPresent( System.out::println );
    }

    static void flatMap() throws Throwable {
	Optional.of( new Outer() )//
	        .flatMap( o -> Optional.ofNullable( o.nested ) )//
	        .flatMap( n -> Optional.ofNullable( n.inner ) )//
	        .flatMap( i -> Optional.ofNullable( i.foo ) )//
	        .ifPresent( System.out::println );
    }
}

class Outer {
    Nested nested;
}

class Nested {
    Inner inner;
}

class Inner {
    String foo;
}