package cn.simple.test.jdkapi.file.jar;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import org.apache.commons.io.IOUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReadJarFile {
    public static void main( String[] args ) throws MalformedURLException {
	readByIO();
	System.out.println( "=======================" );
	readByUri();
	System.out.println( "=======================" );
	readByUrl();
    }

    static void readByIO() {
	try {
	    URI uri = ReadJarFile.class.getResource( "jar-content.txt" ).toURI();
	    log.info( "readByIO uri 1: [{}]", uri );
	    String template = IOUtils.toString( uri, "GBK" );
	    System.out.println( template );
	} catch ( Exception e ) {
	    e.printStackTrace();
	}
    }

    @Deprecated // jar 包内读取有问题
    static void readByUri() {
	try {
	    URI uri = ReadJarFile.class.getResource( "jar-content.txt" ).toURI();
	    log.info( "readByUri uri 1: [{}]", uri );
	    Path path = Paths.get( uri );
	    String template = Files.readAllLines( path, Charset.forName( "GBK" ) ).stream().collect( Collectors.joining( "\n" ) );
	    System.out.println( template );
	} catch ( Exception e ) {
	    e.printStackTrace();
	}
    }

    static void readByUrl() {
	try {
	    URI path = ReadJarFile.class.getResource( "jar-content.txt" ).toURI();
	    log.info( "readByUrl uri 1: [{}]", path );
	    URL url = path.toURL();
	    InputStream is = url.openStream();
	    byte[] bys = new byte[1024_00];
	    int length = is.read( bys );
	    System.out.println( new String( bys, 0, length ) );
	} catch ( Exception e ) {
	    e.printStackTrace();
	}
    }
}
