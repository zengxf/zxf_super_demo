package cn.simple.test.temp;

import java.util.Random;

import lombok.extern.slf4j.Slf4j;

@Slf4j
// M:\project\zxf_super_demo\simple-demo\bin\cn\simple\test\temp
public class TempTest {

    public static void main( String[] args ) {
        log.info( "{}", new Random().nextInt( 2 ) );
        log.info( "{}", new Random().nextInt( 2 ) );
        log.info( "{}", new Random().nextInt( 2 ) );
        log.info( "{}", new Random().nextInt( 2 ) );
        log.info( "{}", new Random().nextInt( 2 ) );
    }

}