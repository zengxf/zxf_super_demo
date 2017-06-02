package cn.zxf.data_bury_point.bury.util;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import cn.zxf.data_bury_point.bury.bo.BuryDataBo;
import lombok.Builder;
import lombok.Data;

public class FilterUtil {

    private static List<FilterBo> filterList;

    public static final String	  ALL_METHOD	    = "*";
    private static final String	  TYPE_PLAIN_SIGN   = "plain";
    private static final String	  TYPE_REGULAR_SIGN = "regular";
    private static final int	  TYPE_PLAIN	    = 0;
    private static final int	  TYPE_REGULAR	    = 1;

    static {
	try {
	    URI uri = FilterUtil.class.getResource( "/filter.conf" ).toURI();
	    Path path = Paths.get( uri );
	    List<String> lines = Files.readAllLines( path );
	    filterList = lines.stream()//
	            .map( String::trim )//
	            .filter( line -> StringUtils.isNoneEmpty( line ) && !line.startsWith( "#" ) )//
	            .map( line -> {
		        String[] arr = line.split( "\\s+" );

		        int type;
		        String value = arr.length == 3 ? arr[2] : arr[1];
		        String method = ALL_METHOD;
		        Pattern pattern = null;

		        if ( arr[0].equalsIgnoreCase( TYPE_PLAIN_SIGN ) ) {
		            type = TYPE_PLAIN;
		        } else if ( arr[0].equalsIgnoreCase( TYPE_REGULAR_SIGN ) ) {
		            type = TYPE_REGULAR;
		            pattern = Pattern.compile( value );
		        } else {
		            throw new RuntimeException( "过滤器的类型设置错误！！！" );
		        }
		        if ( arr.length == 3 ) {
		            method = arr[1].toLowerCase();
		        }

		        FilterBo bo = FilterBo.builder()//
		                .type( type )//
		                .value( value )//
		                .method( method )//
		                .pattern( pattern )//
		                .build();
		        return bo;
	            } )//
	            .collect( Collectors.toList() );
	} catch ( URISyntaxException | IOException e ) {
	    e.printStackTrace();
	}
    }

    /**
     * 判断过滤
     * 
     * @param bo
     * @return true：表示要过滤掉
     */
    public static boolean fliter( BuryDataBo bo ) {
	return filterList.parallelStream() //
	        .anyMatch( filter -> {
	            if ( !filter.getMethod().equals( ALL_METHOD ) // 有设置 method
	                    && !filter.getMethod().equals( bo.getRequestMethod() ) ) {
		        return false;
	            }
	            if ( filter.type == TYPE_PLAIN ) {
		        return filter.value.equals( bo.getPath() );
	            } else {
		        return filter.pattern.matcher( bo.getPath() ).matches();
	            }
	        } );
    }

    // ---------------
    // ---------------

    @Data
    @Builder
    private static class FilterBo {
	private int	type;
	private String	value;
	private String	method;
	private Pattern	pattern;
    }
}
