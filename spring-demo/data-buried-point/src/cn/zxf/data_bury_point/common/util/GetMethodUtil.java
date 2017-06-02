package cn.zxf.data_bury_point.common.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

import cn.zxf.data_bury_point.bury.util.FilterUtil;

public class GetMethodUtil {

    public static String getMethod( HttpServletRequest request ) {
	String method = request.getMethod();
	return StringUtils.isNotEmpty( method ) ? method.toLowerCase() : FilterUtil.ALL_METHOD;
    }

}
