package cn.simple.test.jdkapi.list;

import java.util.ArrayList;

/**
 * trimToSize(); // ��� list �ڲ�����β��Ϊ null ��Ԫ�أ��Խ�ʡ�ռ�
 * 
 * <p>
 * Created by zengxf on 2017-09-29
 */
public class TestArrayList {
    public static void main( String[] args ) {
        ArrayList<String> list = new ArrayList<>( 10 );
        list.add( "a" );
        list.trimToSize();
        System.out.println( list );
    }
}
