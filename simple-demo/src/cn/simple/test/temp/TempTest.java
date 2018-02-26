
package cn.simple.test.temp;

import java.util.HashMap;
import java.util.UUID;

// M:\project\zxf_super_demo\simple-demo\bin\cn\simple\test\temp
public class TempTest {

    public static void main( String[] args ) throws InterruptedException {
        final HashMap<String, String> map = new HashMap<String, String>( 2 );
        Thread t = new Thread( new Runnable() {
            @Override
            public void run() {
                for ( int i = 0; i < 100; i++ ) {
                    new Thread( new Runnable() {
                        @Override
                        public void run() {
                            for ( int i = 0; i < 100; i++ ) {
                                map.put( UUID.randomUUID().toString(), "" );
                            }
                        }
                    }, "ftf" + i ).start();
                }
            }
        }, "ftf" );
        t.start();
        t.join();
    }

}