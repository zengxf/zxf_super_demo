package cn.simple.test.reload_class.myCL;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MyClassLoader extends ClassLoader {

    private String root = "D:/test/md5/";

    @Override
    protected Class<?> loadClass( String name, boolean resolve ) throws ClassNotFoundException {
	Class<?> klass = null;
	try {
	    klass = super.findLoadedClass( name ); // �������Ƿ��Ѿ���װ�ء�
	    if ( klass != null ) {
		return klass;
	    }

	    byte[] bs = this.getClassBytes( name );// ��һ���ض�����ϢԴѰ�Ҳ���ȡ������ֽڡ�
	    if ( bs != null && bs.length > 0 ) {
		klass = super.defineClass( name, bs, 0, bs.length );
	    }
	    if ( klass == null ) { // �����ȡ�ֽ�ʧ�ܣ�����ͼ��JDK��ϵͳAPI��Ѱ�Ҹ��ࡣ
		klass = super.findSystemClass( name );
	    }
	    if ( resolve && klass != null ) {
		super.resolveClass( klass );
	    }
	} catch ( IOException e ) {
	    throw new ClassNotFoundException( e.toString() );
	}
	System.out.println( "klass == " + klass );
	return klass;
    }

    private byte[] getClassBytes( String className ) throws IOException {
	String path = root;
	path += className.substring( className.lastIndexOf( "." ) + 1 ) + ".class";
	System.out.println( path );
	FileInputStream fis = null;
	try {
	    fis = new FileInputStream( path );
	} catch ( FileNotFoundException e ) {
	    System.out.println( e );
	    return null;
	}
	byte[] bs = new byte[fis.available()];
	fis.read( bs );
	fis.close();
	return bs;
    }
}
