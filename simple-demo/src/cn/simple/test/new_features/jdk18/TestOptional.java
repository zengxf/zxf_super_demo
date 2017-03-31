package cn.simple.test.new_features.jdk18;

import java.util.Optional;

/**
 * ��Java 8�У����Ƽ��㷵��null���Ƿ���Optional
 * 
 * @author zengxf
 */
public class TestOptional {
    public static void main( String[] args ) {
	Optional<String> optional = Optional.of( "BAM" );
	System.out.println( optional.isPresent() ); // true
	System.out.println( optional.get() ); // "BAM"
	System.out.println( optional.orElse( "fallback" ) ); // "BAM"
	optional.ifPresent( ( s ) -> System.out.println( s.charAt( 0 ) ) ); // "B"
    }
}
