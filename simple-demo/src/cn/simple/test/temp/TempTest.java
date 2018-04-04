
package cn.simple.test.temp;

import lombok.extern.slf4j.Slf4j;

// M:\project\zxf_super_demo\simple-demo\bin\cn\simple\test\temp
@Slf4j
public class TempTest {

    public static void main( String[] args ) throws CloneNotSupportedException {
        log.info( "int: {}", Integer.toBinaryString((128)) );
        log.info( "int: {}", Integer.numberOfLeadingZeros(128) );

    }

}