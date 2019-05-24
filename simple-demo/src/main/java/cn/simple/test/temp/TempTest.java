package cn.simple.test.temp;

import java.util.stream.Stream;

import lombok.extern.slf4j.Slf4j;

// M:\project\zxf_super_demo\simple-demo\bin\cn\simple\test\temp
@Slf4j
public class TempTest {

    public static void main( String[] args ) throws InterruptedException {
        Stream.of( 23, 4, 54 )
                .forEach( i -> {
                    log.info( "{}", i );
                } );
    }

}