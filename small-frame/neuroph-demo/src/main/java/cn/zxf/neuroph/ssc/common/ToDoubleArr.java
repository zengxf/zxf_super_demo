package cn.zxf.neuroph.ssc.common;

import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class ToDoubleArr {

    public static double[] toDoubleArr( int v, int len ) {
        int fv = 1 << len | v; // 填充
        String str = Integer.toBinaryString( fv );
        String[] arr = str.split( "" );
        return Stream.of( arr ).skip( 1 ).mapToDouble( Double::parseDouble ).toArray();
    }

    public static String toString( double[] arr, int len ) {
        int count = arr.length / len;
        String str = "";
        for ( int i = 0; i < count; i++ ) {
            String bstr = DoubleStream.of( arr ).skip( i * len ).limit( len ) //
                    .boxed().mapToInt( Double::intValue ).mapToObj( v -> v + "" ) //
                    .collect( Collectors.joining( "" ) );
            if ( i > 0 )
                str += ", ";
            str += Integer.valueOf( bstr, 2 );
        }
        return str;
    }

}
