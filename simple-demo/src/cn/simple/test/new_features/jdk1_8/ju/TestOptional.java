package cn.simple.test.new_features.jdk1_8.ju;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * ��Java 8�У����Ƽ��㷵��null���Ƿ���Optional
 * 
 * <p>
 * Created by zxf on 2017-07-06
 */
public class TestOptional {

    public static void main( String[] args ) {
	Outer o = new Outer();
	Nested n = new Nested();
	Inner i = new Inner();
	o.nested = n;
	n.inner = i;
	i.foo = "test";

	// �����������������û�д�ͳ null �����ô�ߵ����ܡ������ڴ��������²�����̫�����⡣
	Optional.of( o )//
	        .map( Outer::getNested )//
	        .map( Nested::getInner )//
	        .map( Inner::getFoo )//
	        .ifPresent( System.out::println );

	Outer obj = o; // new Outer();
	resolve( () -> obj.getNested().getInner().getFoo() ) //
	        .ifPresent( System.out::println );

	test( o );
    }

    static void test( Outer v ) {
	Optional.of( v )//
	        .flatMap( o -> Optional.ofNullable( o.nested ) )//
	        .flatMap( n -> Optional.ofNullable( n.inner ) )//
	        .flatMap( i -> Optional.ofNullable( i.foo ) )//
	        .ifPresent( System.out::println );
    }

    public static < T > Optional<T> resolve( Supplier<T> resolver ) {
	try {
	    T result = resolver.get();
	    return Optional.ofNullable( result );
	} catch ( NullPointerException e ) {
	    return Optional.empty();
	}
    }

    static class Outer {
	Nested nested;

	Nested getNested() {
	    return nested;
	}
    }

    static class Nested {
	Inner inner;

	Inner getInner() {
	    return inner;
	}
    }

    static class Inner {
	String foo;

	String getFoo() {
	    return foo;
	}
    }

}
