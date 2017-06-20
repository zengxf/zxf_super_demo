package cn.zxf.data_bury_point.common.wrapper;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * 为消除“IllegalStateException: getReader() has already been called for this request”异常， <br>
 * 自定义一个 Request 封装
 * 
 * <p>
 * Created by zxf on 2017-06-20
 */
public class MyHttpServletRequestWrapper extends HttpServletRequestWrapper {

    private final byte[] body;

    public MyHttpServletRequestWrapper( HttpServletRequest request ) throws IOException {
	super( request );
	InputStream stream = request.getInputStream();
	byte[] arr = this.getBytes( stream );
	body = arr;
    }

    /**
     * 从流里面获取二进制数组
     *
     * @param stream
     * @return
     * @throws IOException
     */
    private byte[] getBytes( InputStream stream ) throws IOException {
	byte[] arr = new byte[0];
	byte[] temp = new byte[1024];
	int readLen;
	while ( ( readLen = stream.read( temp ) ) > -1 ) {
	    int arrLen = arr.length;
	    arr = Arrays.copyOf( arr, arrLen + readLen ); // 扩充长度并重新赋值给 arr
	    System.arraycopy( temp, 0, arr, arrLen, readLen ); // 将读取出来的所有数据复制给 arr
	}
	return arr;
    }

    @Override
    public BufferedReader getReader() throws IOException {
	return new BufferedReader( new InputStreamReader( getInputStream() ) );
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
	final ByteArrayInputStream stream = new ByteArrayInputStream( body );
	return new MyServletInputStream( stream, body.length );
    }

    // ---------
    // ---------

    public static class MyServletInputStream extends ServletInputStream {
	int		     p = 0;
	int		     len;
	ByteArrayInputStream stream;

	public MyServletInputStream( ByteArrayInputStream stream, int len ) {
	    this.stream = stream;
	    this.len = len;
	}

	@Override
	public boolean isFinished() {
	    return p + 1 == len;
	}

	@Override
	public boolean isReady() {
	    return p + 1 < len;
	}

	@Override
	public int read() throws IOException {
	    p++;
	    return stream.read();
	}

	@Override
	public void setReadListener( ReadListener readListener ) {
	}
    }

}
