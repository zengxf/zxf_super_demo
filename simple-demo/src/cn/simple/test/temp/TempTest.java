
package cn.simple.test.temp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TempTest {

    public static void main( String[] args ) {
	List<String> list = new ArrayList<>();
	list.add( "a" );
	Stream<String> str = list.stream();
	list.add( "c" );
	str.forEach( System.out::println );
    }

}