package cn.simple.test.temp;

import java.util.ArrayList;
import java.util.List;

// M:\project\zxf_super_demo\simple-demo\bin\main\cn\simple\test\temp
public class TempTest {

    public static void main( String[] args ) {
        List<String> list = new ArrayList<>();
        list.add( "dd" );
        list.add( 0, "cc" );
        list.add( 0, "bb" );
        list.add( 0, "aa" );
        System.out.println( list );
    }

}