
package cn.simple.test.temp;

import java.util.Date;

import lombok.extern.slf4j.Slf4j;

// M:\project\zxf_super_demo\simple-demo\bin\cn\simple\test\temp
@Slf4j
public class TempTest {
    public static void main( String[] args ) {
         String s = String.format("%tY-%<tm", new Date(System.currentTimeMillis()- 30L*24*60*60*1000));
         System.out.println( s );
        log.error( "test: {}", "bb", new Exception( "ttt" ) );
    }
}