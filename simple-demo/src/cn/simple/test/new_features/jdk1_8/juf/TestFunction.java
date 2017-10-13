package cn.simple.test.new_features.jdk18.juf;

import java.util.function.Function;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestFunction {
    public static void main( String[] args ) {
	Function<String, Integer> fun = ( str ) -> {
	    log.info( "fun => str: {}", str );
	    return str.length();
	};

	// 顺序调用：调用自己完再调用后面的
	Function<String, Integer> fun2 = fun //
	        .andThen( ( i ) -> {
	            log.info( "fun2.andThen => i: {}", i );
	            return "len: " + i;
	        } ) //
	        .andThen( str -> {
	            log.info( "fun2.andThen2 => str: {}", str );
	            return str.length();
	        } );
	System.out.println( fun2.apply( "test" ) );

	System.out.println();
	System.out.println();

	// 反序调用：调用完后面的再调用自己的
	Function<String, Integer> fun3 = fun.compose( i -> {
	    log.info( "fun3 => i: {}", i );
	    return i + 3;
	} );
	System.out.println( fun3.apply( "test" ) );
    }
}
