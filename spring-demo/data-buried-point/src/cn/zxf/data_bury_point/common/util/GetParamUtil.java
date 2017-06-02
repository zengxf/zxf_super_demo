package cn.zxf.data_bury_point.common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSONObject;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GetParamUtil {

    public static Map<String, Object> getParam( HttpServletRequest request ) throws IOException {
	Map<String, Object> param = new HashMap<>();

	Map<String, String[]> paramMap = request.getParameterMap();
	paramMap.forEach( ( key, value ) -> {
	    Object v = value.length == 1 ? value[0] : value;
	    param.put( key, v );
	} );

	if ( "post".equalsIgnoreCase( request.getMethod() ) //
	        && "application/json".equals( request.getContentType() ) ) { // post 请求且 json 格式传参
	    try {
		JSONObject jsonObj = getJson( request );
		param.putAll( jsonObj );
	    } catch ( Exception e ) {
		log.error( "POST 解析 json 参数出错：{}", e.getMessage() );
	    }
	}

	return param;
    }

    static JSONObject getJson( HttpServletRequest request ) throws IOException {
	StringBuilder json = new StringBuilder();
	BufferedReader reader = request.getReader();
	String line;
	while ( ( line = reader.readLine() ) != null ) {
	    json.append( line );
	}

	JSONObject jsonObj = JSONObject.parseObject( json.toString() );
	return jsonObj;
    }

}
