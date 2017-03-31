package cn.simple.test.new_features.jdk18;

import java.util.HashMap;
import java.util.Map;

public class TestMap {
    public static void main( String[] args ) {
	Map<Integer, String> map = new HashMap<>();
	for ( int i = 0; i < 10; i++ ) {
	    map.putIfAbsent( i % 5, "val" + i ); // ��������򲻸���
	}
	System.out.println( map );

	map.forEach( ( k, v ) -> { // ����
	    System.out.print( k + " : " + v + "; " );
	} );
	System.out.println();

	map.computeIfPresent( 3, ( num, val ) -> val + num ); // ��������㲢�������ڵ�ֵ
	System.out.println( map.get( 3 ) ); // val33

	map.computeIfPresent( 9, ( num, val ) -> null ); // Ϊ null ��ɾ����
	System.out.println( map.containsKey( 9 ) ); // false

	map.computeIfAbsent( 23, num -> "val" + num ); // �������������㲢����
	System.out.println( map.containsKey( 23 ) ); // true

	map.computeIfAbsent( 3, num -> "bam" ); // �����򲻴���
	System.out.println( map.get( 3 ) ); // val33

	map.remove( 3, "val3" ); // ɾ��һ����ֵȫ��ƥ�����
	System.out.println( map.get( 3 ) ); // val33
	map.remove( 3, "val33" );
	System.out.println( map.get( 3 ) ); // null

	System.out.println( map.getOrDefault( 42, "not found" ) ); // not found

	map.merge( 9, "val9", ( value, newValue ) -> value.concat( newValue ) );// �����������
	System.out.println( map.get( 9 ) ); // val9
	map.merge( 9, "concat", ( value, newValue ) -> value.concat( newValue ) );// ������ϲ�����
	System.out.println( map.get( 9 ) ); // val9concat

    }
}
