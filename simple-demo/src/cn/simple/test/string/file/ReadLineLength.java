package cn.simple.test.string.file;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadLineLength {
    public static void main( String[] args ) throws IOException {
	String path = ReadLineLength.class.getResource( "" ).getPath() + "common.txt";

	BufferedReader br = new BufferedReader( new InputStreamReader( new FileInputStream( path ) ) );

	String line;
	while ( ( line = br.readLine() ) != null ) {
	    System.out.println( line.length() );
	}

	br.close();
    }
}
