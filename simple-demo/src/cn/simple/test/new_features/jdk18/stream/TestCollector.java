package cn.simple.test.new_features.jdk18.stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestCollector {
    public static void main( String[] args ) {
	Integer size = Stream.of( "a", "b" ).collect( collectingAndThen( toList(), List::size ) );
	log.info( "size: {}", size );
	System.out.println( "----------" );

	Map<?, ?> booleanMap = Stream.of( "a", "b", "c1" ).collect( Collectors.partitioningBy( s -> s.length() > 1 ) );
	log.info( "map: {}", booleanMap );
	System.out.println( "----------" );
    }
}
