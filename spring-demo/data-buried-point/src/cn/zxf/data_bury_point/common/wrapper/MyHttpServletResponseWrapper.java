package cn.zxf.data_bury_point.common.wrapper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class MyHttpServletResponseWrapper extends HttpServletResponseWrapper {

    private ByteArrayOutputStream buffer;
    private ServletOutputStream	  out;

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

    public byte[] getContent() throws IOException {
	this.flushBuffer();
	return buffer.toByteArray();
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