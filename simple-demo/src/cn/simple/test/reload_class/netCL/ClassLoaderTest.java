package cn.simple.test.reload_class.netCL;

public class ClassLoaderTest {

    public static void main( String[] args ) {
	try {

	    String rootUrl = "https://raw.githubusercontent.com/zengxf/GitTest/master/classes";
	    NetworkClassLoader networkClassLoader = new NetworkClassLoader( rootUrl );
	    /**
	     * ����ʱ����Ҫ�Ȱ� NetClassLoaderTestC1 ɾ��
	     */
	    String classname = "cn.simple.test.reload_class.netCL.NetClassLoaderTestC1";
	    Class<?> clazz = networkClassLoader.loadClass( classname );
	    System.out.println( clazz.getClassLoader() );

	} catch ( Exception e ) {
	    e.printStackTrace();
	}
    }

}
