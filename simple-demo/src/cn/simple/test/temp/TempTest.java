
package cn.simple.test.temp;

import java.io.IOException;

public class TempTest {

    public static void main( String[] args ) throws IOException, InterruptedException {
        Runtime rt = Runtime.getRuntime();
        try {
            rt.exec( new String[] { "cmd.exe", "/c", "cd /d M:\\project\\zxf_super_demo\\small-frame\\btrace-demo\\src\\main\\java\\cn\\zxf\\btrace\\demo\\duration && start " } );
        } catch ( IOException e ) {
            e.printStackTrace();
        }
        while ( true ) {
            System.out.println( System.currentTimeMillis() );
            Thread.sleep( 1000L );
        }
    }

}