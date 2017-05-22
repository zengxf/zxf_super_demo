
package cn.simple.test.temp;

import java.io.IOException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TempTest {

    public static void main( String[] args ) throws IOException {
	Stream.of(1,2)
	.map( Integer::toBinaryString )
	.collect( Collectors.toList() );
    }

}
