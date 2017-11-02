package cn.simple.util.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 非线程安全
 * 
 * @author zxf
 */
public class IoFileWriter implements AutoCloseable {
    private static final int   MAX_BUFFER = 2000;

    private String	       path;
    private final List<String> lines	  = new ArrayList<>();

    public static IoFileWriter of( String path ) {
	return new IoFileWriter( path );
    }

    public IoFileWriter( String path ) {
	this.path = path;

	File file = new File( path );
	if ( file.exists() ) {
	    file.delete();
	}
    }

    public void append( String line ) {
	if ( !line.endsWith( "\n" ) )
	    line += "\n";
	lines.add( line );
	if ( lines.size() >= MAX_BUFFER ) {
	    this.write( lines );
	}
    }

    public void flush() {
	this.write( lines );
    }

    public void write( List<String> lines ) {
	try ( FileWriter fw = new FileWriter( path, true ) ) {
	    lines.forEach( t -> {
		try {
		    fw.write( t );
		    fw.flush();
		} catch ( IOException e ) {
		    e.printStackTrace();
		}
	    } );
	} catch ( IOException e ) {
	    e.printStackTrace();
	}
	lines.clear();
    }

    @Override
    public void close() throws Exception {
	this.flush();
    }

}
