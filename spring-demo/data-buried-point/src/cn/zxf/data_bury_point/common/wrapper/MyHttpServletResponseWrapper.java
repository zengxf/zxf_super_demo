package cn.zxf.data_bury_point.common.wrapper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class MyHttpServletResponseWrapper extends HttpServletResponseWrapper {

    private ByteArrayOutputStream buffer;
    private ServletOutputStream	  out;
    private Map<String, Object>	  hander = new HashMap<>();

    public MyHttpServletResponseWrapper( HttpServletResponse response ) {
	super( response );
	buffer = new ByteArrayOutputStream();
	out = new MyServletOutputStream( buffer );
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
	return out;
    }

    @Override
    public void flushBuffer() throws IOException {
	if ( out != null ) {
	    out.flush();
	}
    }

    @Override
    public void addHeader( String name, String value ) {
	hander.put( name, value );
	super.addHeader( name, value );
    }

    @Override
    public void setHeader( String name, String value ) {
	hander.put( name, value );
	super.setHeader( name, value );
    }

    @Override
    public void setIntHeader( String name, int value ) {
	hander.put( name, value );
	super.setIntHeader( name, value );
    }

    @Override
    public void addIntHeader( String name, int value ) {
	hander.put( name, value );
	super.addIntHeader( name, value );
    }

    @Override
    public void setDateHeader( String name, long date ) {
	hander.put( name, date );
	super.setDateHeader( name, date );
    }

    @Override
    public void addDateHeader( String name, long date ) {
	hander.put( name, date );
	super.addDateHeader( name, date );
    }

    // ---------------------
    // ---------------------

    public byte[] getContent() throws IOException {
	this.flushBuffer();
	return buffer.toByteArray();
    }

    public Map<String, Object> getAllHandler() {
	return this.hander;
    }

    // ---------
    // ---------

    public static class MyServletOutputStream extends ServletOutputStream {
	private ByteArrayOutputStream bos;

	public MyServletOutputStream( ByteArrayOutputStream bos ) {
	    this.bos = bos;
	}

	@Override
	public void write( int b ) throws IOException {
	    bos.write( b );
	}

	@Override
	public boolean isReady() {
	    return true;
	}

	@Override
	public void setWriteListener( WriteListener listener ) {
	}
    }

}