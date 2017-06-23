package cn.zxf.data_bury_point.common;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import cn.zxf.data_bury_point.bury.BuryDataService;
import cn.zxf.data_bury_point.bury.bo.BuryDataBo;
import cn.zxf.data_bury_point.common.util.GetMethodUtil;
import cn.zxf.data_bury_point.common.util.GetParamUtil;
import cn.zxf.data_bury_point.common.util.GetPathUtil;
import cn.zxf.data_bury_point.common.util.GetUserUtil;
import cn.zxf.data_bury_point.common.wrapper.MyHttpServletRequestWrapper;
import cn.zxf.data_bury_point.common.wrapper.MyHttpServletResponseWrapper;
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
	MyHttpServletRequestWrapper reqWrapper = new MyHttpServletRequestWrapper( hsr );
	MyHttpServletResponseWrapper resWrapper = new MyHttpServletResponseWrapper( hsRes );

	String userId = GetUserUtil.getUserId( hsr );
	String path = GetPathUtil.getPath( hsr );
	String method = GetMethodUtil.getMethod( hsr );
	Map<String, Object> param = GetParamUtil.getParam( reqWrapper );
	int result = 1;
	int status = 200;
	String contentJson = null;

	Exception ex = null;
	try {
	    chain.doFilter( reqWrapper, resWrapper );

	    byte[] content = resWrapper.getContent();
	    status = resWrapper.getStatus();

	    String resType = resWrapper.getContentType();
	    if ( resType.startsWith( "application/json" ) ) {
		contentJson = new String( content );
	    }

	    ServletOutputStream out = response.getOutputStream();
	    out.write( content );
	    out.flush();
	} catch ( Exception e ) {
	    log.error( "error : {}", e.getMessage() );
	    result = 0;
	    ex = e;
	}
	log.info( "path: {}, userId: {}, result: {}", path, userId, result );

	this.handleBury( userId, path, method, param, result, status, contentJson );

	if ( ex != null ) {
	    throw new ServletException( ex ); // 包装下抛出
	}
    }

    // 处理埋点
    private void handleBury( String userId, String path, String method, Map<String, Object> param, int result, int status, String contentJson ) {
	if ( status != 404 ) {
	    try {
		BuryDataBo item = BuryDataBo.builder() //
		        .userId( userId ) //
		        .path( path ) //
		        .requestMethod( method )//
		        .param( param ) //
		        .result( result ) //
		        .status( status ) //
		        .contentJson( contentJson ) //
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

}
