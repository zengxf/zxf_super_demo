package cn.simple.test.new_features.jdk18;

import java.util.HashMap;
import java.util.Map;

public class TestMap {
    public static void main( String[] args ) {
	Map<Integer, String> map = new HashMap<>();
	for ( int i = 0; i < 10; i++ ) {
	    map.putIfAbsent( i % 5, "val" + i ); // 如果存在则不覆盖
	}
	System.out.println( map );

	map.forEach( ( k, v ) -> { // 遍历
	    System.out.print( k + " : " + v + "; " );
	} );
	System.out.println();

	map.computeIfPresent( 3, ( num, val ) -> val + num ); // 存在则计算并重置现在的值
	System.out.println( map.get( 3 ) ); // val33

	map.computeIfPresent( 9, ( num, val ) -> null ); // 为 null 则删除键
	System.out.println( map.containsKey( 9 ) ); // false

	map.computeIfAbsent( 23, num -> "val" + num ); // 如果不存在则计算并插入
	System.out.println( map.containsKey( 23 ) ); // true

	map.computeIfAbsent( 3, num -> "bam" ); // 存在则不处理
	System.out.println( map.get( 3 ) ); // val33

	map.remove( 3, "val3" ); // 删除一个键值全都匹配的项
	System.out.println( map.get( 3 ) ); // val33
	map.remove( 3, "val33" );
	System.out.println( map.get( 3 ) ); // null

	System.out.println( map.getOrDefault( 42, "not found" ) ); // not found

	map.merge( 9, "val9", ( value, newValue ) -> value.concat( newValue ) );// 不存在则插入
	System.out.println( map.get( 9 ) ); // val9
	map.merge( 9, "concat", ( value, newValue ) -> value.concat( newValue ) );// 存在则合并处理
	System.out.println( map.get( 9 ) ); // val9concat

    }
}
