package test.temp;

import lombok.extern.slf4j.Slf4j;

// M:\zxf-demo-github\zxf_super_demo\simple-demo\bin\main\test\temp
@Slf4j
public class TempTest {

    private int a = 2;
    private int b;
    private int c;

    {
        b = 3;
        log.info( "普通块" );
        log.info( "{},{},{}", a, b, c );
    }

    TempTest() {
        c = 44;
        log.info( "构造函数" );
        log.info( "{},{},{}", a, b, c );
    }

    public static void main( String[] args ) throws Exception {
        new TempTest();
    }

}
