package cn.zxf.data_bury_point.common;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ReadListener;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import cn.zxf.data_bury_point.bury.BuryDataService;
import cn.zxf.data_bury_point.bury.bo.BuryDataBo;
import cn.zxf.data_bury_point.common.util.GetMethodUtil;
import cn.zxf.data_bury_point.common.util.GetParamUtil;
import cn.zxf.data_bury_point.common.util.GetPathUtil;
import cn.zxf.data_bury_point.common.util.GetUserUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebFilter( "/api/*" )
public class BuryFilter implements Filter {

    @Autowired
    private BuryDataService service;

    @Override
    public void init( FilterConfig filterConfig ) throws ServletException {
	log.info( "BuriedFilter - init" );
    }

    @Override
    public void doFilter( ServletRequest request, ServletResponse response, FilterChain chain ) throws IOException, ServletException {
	HttpServletRequest hsr = (HttpServletRequest) request;
	HttpServletResponse hsRes = (HttpServletResponse) response;
	BodyReaderHttpServletRequestWrapper wrapper = new BodyReaderHttpServletRequestWrapper( hsr );

	String userId = GetUserUtil.getUserId( hsr );
	String path = GetPathUtil.getPath( hsr );
	String method = GetMethodUtil.getMethod( hsr );
	Map<String, Object> param = GetParamUtil.getParam( wrapper );
	int result = 1;
	int status = 200;

	Exception ex = null;
	try {
	    chain.doFilter( wrapper, response );
	    status = hsRes.getStatus();
	} catch ( Exception e ) {
	    log.error( "error : {}", e.getMessage() );
	    result = 0;
	    ex = e;
	}
	log.info( "path: {}, userId: {}, result: {}", path, userId, result );

	this.handleBury( userId, path, method, param, result, status );

	if ( ex != null ) {
	    throw new ServletException( ex ); // 包装下抛出
	}
    }

    // 处理埋点
    private void handleBury( String userId, String path, String method, Map<String, Object> param, int result, int status ) {
	if ( status != 404 ) {
	    try {
		BuryDataBo item = BuryDataBo.builder() //
		        .userId( userId ) //
		        .path( path ) //
		        .requestMethod( method )//
		        .param( param ) //
		        .result( result ) //
		        .status( status ) //
		        .build();
		service.handle( item );
	    } catch ( Exception e ) {
		log.error( "handle bury data error!!!", e );
	    }
	} else {
	    log.info( "用户请求 404，不做记录！！！" );
	}
	System.out.println();
    }

    @Override
    public void destroy() {
	log.info( "BuriedFilter - destroy" );
    }

    // ----------------------------
    // ----------------------------

    /**
     * 为消除“IllegalStateException: getReader() has already been called for this request”异常， <br>
     * 自定义一个 Request 封装
     */
    private static final class BodyReaderHttpServletRequestWrapper extends HttpServletRequestWrapper {

	private final byte[] body;

	public BodyReaderHttpServletRequestWrapper( HttpServletRequest request ) throws IOException {
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

	    return new ServletInputStream() {
		int len	= body.length;
		int p	= 0;

		@Override
		public boolean isFinished() {
		    return p + 1 == len;
		}

		@Override
		public boolean isReady() {
		    return p + 1 < len;
		}

		@Override
		public void setReadListener( ReadListener readListener ) {
		}

		@Override
		public int read() throws IOException {
		    p++;
		    return stream.read();
		}
	    };
	}

    }

}
