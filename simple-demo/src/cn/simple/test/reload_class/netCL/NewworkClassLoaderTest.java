package cn.simple.test.reload_class.netCL;

public class NewworkClassLoaderTest {
    public static void main( String[] args ) {
	try {
	    // 娴嬭瘯鍔犺浇缃戠粶涓殑class鏂囦欢
	    String rootUrl = "https://raw.githubusercontent.com/zengxf/GitTest/master/classes";
	    String className = "cn.simple.test.reload_class.netCL.NetClassLoaderSimple";
	    NetworkClassLoader ncl1 = new NetworkClassLoader( rootUrl );
	    NetworkClassLoader ncl2 = new NetworkClassLoader( rootUrl );
	    Class<?> clazz1 = ncl1.loadClass( className );
	    Class<?> clazz2 = ncl2.loadClass( className );
	    Object obj1 = clazz1.newInstance();
	    Object obj2 = clazz2.newInstance();
	    clazz1.getMethod( "setNetClassLoaderSimple", Object.class ).invoke( obj1, obj2 );
	    System.out.println( clazz1.getClassLoader() );
	    System.out.println( clazz2.getClassLoader() );
	} catch ( Exception e ) {
	    e.printStackTrace();
	}
    }
}
