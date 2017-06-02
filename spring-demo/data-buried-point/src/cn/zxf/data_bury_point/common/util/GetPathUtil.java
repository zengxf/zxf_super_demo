package cn.zxf.data_bury_point.common.util;

import javax.servlet.http.HttpServletRequest;

public class GetPathUtil {

    public static String getPath( HttpServletRequest request ) {
	return request.getServletPath();
    }

}
