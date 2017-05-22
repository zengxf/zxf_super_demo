package cn.simple.test.jdkapi.file;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

public class ImageToBase64 {
    public static void main( String[] args ) throws URISyntaxException, IOException {
	Path src = Paths.get( ImageToBase64.class.getResource( "hunterplus.png" ).toURI() );
	ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
	Files.copy( src, byteOut );
	byte[] content = byteOut.toByteArray();
	String b64 = Base64.getEncoder().encodeToString( content );
	System.out.println( b64 );
    }
}
