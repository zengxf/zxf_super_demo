
package cn.simple.test.temp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TempTest {

    public static void main( String[] args ) throws IOException {
	List<String> list = new ArrayList<>();
	list.add( "ab@dd.cn；  cc@db.cn;  dds@d.ds" );
	list.add( "bb@dd.cn" );
	String[] arr = getArray( list );
	System.out.println( Arrays.toString( arr ) );
    }

    static String[] getArray( List<String> list ) {
	Set<String> temp = new HashSet<>();
	for ( String str : list ) {
	    String[] arr = str.split( "\\s*(;|；)\\s*" );
	    for ( String item : arr ) {
		temp.add( item );
	    }
	}
	return temp.toArray( new String[] {} );
    }
}