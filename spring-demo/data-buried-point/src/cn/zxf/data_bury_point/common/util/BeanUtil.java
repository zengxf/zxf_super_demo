package cn.zxf.data_bury_point.common.util;

import org.springframework.beans.BeanUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BeanUtil {

    public static void copyProperties( final Object orig, final Object dest ) {
	try {
	    BeanUtils.copyProperties( orig, dest );
	} catch ( Exception e ) {
	    log.error( "BeanUtil-copyProperties error, dest: {}, orig: {}", dest, orig );
	    log.error( "", e );
	}
    }

}
