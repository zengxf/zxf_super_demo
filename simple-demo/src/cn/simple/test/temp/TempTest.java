
package cn.simple.test.temp;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TempTest {

    public static void main( String[] args ) throws Exception {
        log.info( "{}", Arrays.toString( "ab Ab SS".split( "\\PL" ) ) );
        List<String> list = Stream.of( "1", "2", "3", "4" ).collect( Collectors.toList() );
        System.out.println( list.subList( 0, 2 ) );
        System.out.println( list.subList( 2, list.size() ) );
    }

    @Data
    public static class Test {
        final Integer a;
        final String  b;

        public Test( Integer a, String b ) {
            this.a = a;
            this.b = b;
        }
    }

}