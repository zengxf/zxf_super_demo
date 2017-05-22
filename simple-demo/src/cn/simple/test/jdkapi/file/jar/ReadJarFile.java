package cn.simple.test.jdkapi.file.jar;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReadJarFile {
    public static void main( String[] args ) throws MalformedURLException {
	readByUrl();
    }

    static void readByUrl() {
	try {
	    URI path = ReadJarFile.class.getResource( "jar-content.txt" ).toURI();
	    log.info( "path 1: {}", path );
	    String jarPath = path.toString();
	    log.info( "jarPath 1: {}", jarPath );
	    URL url = new URL( jarPath );
	    InputStream is = url.openStream();
	    byte[] bys = new byte[1024_00];
	    int length = is.read( bys );
	    System.out.println( new String( bys, 0, length ) );
	} catch ( Exception e ) {
	    e.printStackTrace();
	}
    }
}
