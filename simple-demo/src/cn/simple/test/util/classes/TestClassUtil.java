package cn.simple.test.util.classes;

import cn.simple.test.util.compare_field.TestCompareObj;
import cn.simple.util.classes.ClassUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestClassUtil {
    public static void main( String[] args ) {
	ClassUtil.getFields( TestCompareObj.class ).forEach( System.out::println );
	log.info( "fuck log" );
    }
}
