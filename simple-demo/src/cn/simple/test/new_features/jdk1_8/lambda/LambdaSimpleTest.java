package cn.simple.test.new_features.jdk1_8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class LambdaSimpleTest {

    public static void main( String[] args ) throws Exception {

        List<String> list = new ArrayList<>();
        list.add( "ddd" );
        list.add( "cccc" );
        list.add( "cccac" );
        list.add( "ccc33ac" );
        list.add( "ccc33acaa" );
        list.add( "ccc33acaabb" );

        // list.stream().peek(System.out::println);

        list.stream().peek( //
                ( str ) -> //
                System.out.println( str )//
        );

        List<Integer> lens = new ArrayList<>();
        Stream<String> stream1 = list.parallelStream();
        stream1.map( //
                ( str ) -> str.length()//
        ).forEach( lens::add );
        stream1.close();
        System.out.println( lens );

        // list.parallelStream().flatMap(mapper)

        list.stream().limit( 2 ).skip( 2 ).forEach( System.out::println );

        List<Integer> nums = Arrays.asList( 1, 1, null, 2, 3, 4, null, 5, 6, 7, 8, 9, 10 );
        System.out.println( "sum is:" + nums.stream().filter( num -> num != null )//
                // .peek(System.out::println)//
                .distinct()//
                .mapToInt( num -> num * 2 )//
                // .peek(System.out::println)//
                .skip( 2 ).limit( 4 ).sum() );

        List<Integer> ints = Arrays.asList( 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 );
        System.out.println( "ints sum is:" + ints.stream().reduce( ( sum, item ) -> sum + item ).get() );

    }

}
