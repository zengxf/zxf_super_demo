package cn.simple.test.temp;

import lombok.extern.slf4j.Slf4j;

// M:\project\zxf_super_demo\simple-demo\bin\cn\simple\test\temp
@Slf4j
public class TempTest {

    public static void main( String[] args ) throws InterruptedException {
        long l1 = System.currentTimeMillis() << 32;
        System.out.println( Long.toString( l1, 2 ) );
        System.out.println( Long.toString( l1, 36 ) );
        log.info("ddd");
    }

}