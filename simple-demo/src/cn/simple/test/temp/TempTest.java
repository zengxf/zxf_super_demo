
package cn.simple.test.temp;

// M:\project\zxf_super_demo\simple-demo\bin\cn\simple\test\temp
public class TempTest {
    /**
     * > 1111
     * - 1110 +
     * = 1110
     * - 1101 +
     * = 1100
     * - 1010 +
     * = 1000
     * - 0100 +
     * = 0000
     * 
     * @param args
     * @throws Exception
     */
    public static void main( String[] args ) throws Exception {
        System.out.println( 11 & 10 );
        System.out.println( 5 & 4 );
        System.out.println( 4 & 3 );
        System.out.println( 3 & 2 );

        // System.out.println( Integer.toBinaryString( -1 ) );
        // System.out.println( Integer.toBinaryString( -2 ) );
    }

}