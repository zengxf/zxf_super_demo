package cn.simple.test.new_features.jdk17;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class TestFiles {
    public static void main( String[] args ) throws IOException {
	// testCopy();

	testCreateDirectory();
    }

    static void testCreateDirectory() throws IOException {
	Files.createDirectories( Paths.get( "D:/test/jdk17", "aa/bb" ) );
	Files.createDirectory( Paths.get( "D:/test/jdk17", "bb" ) );
    }

    static void testCopy() throws FileNotFoundException, IOException {
	Path target = Paths.get( "D:/test/jdk17", "bbb.txt" );
	InputStream in = new FileInputStream( "D:/test/jdk17/aaa.txt" );
	Files.copy( in, target, StandardCopyOption.REPLACE_EXISTING );
    }
}
