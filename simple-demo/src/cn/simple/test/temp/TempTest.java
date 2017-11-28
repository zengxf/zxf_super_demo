
package cn.simple.test.temp;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

public class TempTest {

    public static void main( String[] args ) throws Exception {
        test( null );
        test1( null );
    }

    static void test( @Nullable String msg ) {
        System.out.println( msg );
    }

    static void test1( @NotNull String msg ) {
        System.out.println( msg );
    }

}