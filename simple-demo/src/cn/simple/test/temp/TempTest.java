
package cn.simple.test.temp;

public class TempTest {

    static interface IEnum {
	String name();
    }

    static enum Type implements IEnum {
	TEST_, TEST
    }

    public static void main( String[] args ) throws InterruptedException {
	System.out.println( System.currentTimeMillis() );
    }

    static String name( String name ) {
	if ( !name.contains( "_" ) ) {
	    return name.toLowerCase();
	}
	String[] nameArr = name.split( "_" );
	String result = nameArr[0].toLowerCase();
	for ( int i = 1; i < nameArr.length; i++ ) {
	    result += nameArr[i].substring( 0, 1 ) + nameArr[i].substring( 1 ).toLowerCase();
	}
	return result;
    }

}