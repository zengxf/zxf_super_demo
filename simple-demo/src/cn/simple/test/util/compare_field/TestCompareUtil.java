package cn.simple.test.util.compare_field;

import java.util.Date;
import java.util.List;

import cn.simple.util.compare_field.CompareDifferentPiece;
import cn.simple.util.compare_field.CompareFieldChangeUtil;

public class TestCompareUtil {
    public static void main( String[] args ) {

	TestCompareObj oldObj = new TestCompareObj( "zxf1", null, new Date() );
	TestCompareObj newObj = new TestCompareObj( "zxf2", 2, null );

	newObj.setSuperAge( 10 );
	newObj.setSuperName( "10" );

	oldObj.setSuperAge( 11 );
	oldObj.setSuperName( "11" );

	oldObj.setInternal( new TestCompareObjInter( "aa", 122 ) );
	newObj.setInternal( new TestCompareObjInter( null, 12 ) );

	List<CompareDifferentPiece> list = CompareFieldChangeUtil.compare( oldObj, newObj );
	list.forEach( System.out::println );

    }
}
