package cn.simple.test.temp;

import lombok.extern.slf4j.Slf4j;

// cd /d F:/project/MyProject/mars/SimpleDemo/bin
// F:/project/MyProject/mars/SimpleDemo/bin/cn/simple/test/temp
// java cn.simple.test.temp.TempTest
@Slf4j
class TempTest {

    public static void main( String[] args ) throws Throwable {
	System.out.println( ( Long.MAX_VALUE - System.nanoTime() ) / 1000_000_0000L / 60 / 60 / 24 / 365 );
    }

}