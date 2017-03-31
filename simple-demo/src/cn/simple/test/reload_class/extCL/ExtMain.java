package cn.simple.test.reload_class.extCL;

public class ExtMain {
    public static void main( String[] args ) {
	ClassLoader cl = ExtC1.class.getClassLoader();
	while ( true ) {
	    System.out.println( cl );
	    cl = cl.getParent();
	    if ( cl == null ) {
		System.out.println( "无：BootClassLoader" );
		break;
	    }
	}
    }
}
