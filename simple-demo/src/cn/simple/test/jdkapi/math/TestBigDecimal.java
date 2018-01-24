package cn.simple.test.jdkapi.math;

import java.math.BigDecimal;
import java.util.stream.Stream;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestBigDecimal {
    public static void main( String[] args ) {
        divide();
//        log.info( "{}", new DecimalFormat( "#.##" ).format( BigDecimal.valueOf( 23.324543 ).multiply( BigDecimal.valueOf( 23.324543 ) ) ) );
    }

    static void divide() {
        BigDecimal value1 = BigDecimal.valueOf( 23.324543 );
        BigDecimal total = BigDecimal.valueOf( 55.324543 );
        log.info( "23.324543 - v: {}", value1 );
        log.info( "55.324543 - v: {}", total );
        log.info( "divide - v: {}", value1.divide( total, 2 ) );
        log.info( "divide - v: {}", value1.divide( total, BigDecimal.ROUND_HALF_EVEN ).setScale( 2, BigDecimal.ROUND_HALF_EVEN ) );
        log.info( "divide - v: {}", value1.divide( total, BigDecimal.ROUND_HALF_EVEN ).multiply( BigDecimal.valueOf( 10000 ) ).intValue() );
    }

    static void total() {
        BigDecimal total = Stream.of( 23.3, 23.54, 12.32 ) //
                .map( BigDecimal::valueOf ) //
                .peek( v -> log.info( "v: {}", v ) ) //
                .reduce( BigDecimal::add ) //
                .orElse( BigDecimal.ZERO );
        log.info( "total: {}", total );
    }
}
