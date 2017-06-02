package cn.zxf.data_bury_point.bury;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.zxf.data_bury_point.bury.bo.BuryDataBo;
import cn.zxf.data_bury_point.bury.util.FilterUtil;
import cn.zxf.data_bury_point.common.util.BeanUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * 埋点数据服务类
 * 
 * <p>
 * Created by zxf on 2017-06-01
 */
@Component
@Slf4j
public class BuryDataService {

    @Autowired
    private BuryDataMongoDao dao;

    /**
     * 对埋点数据进行处理
     * 
     * @param item
     */
    public void handle( BuryDataBo data ) {
	if ( FilterUtil.fliter( data ) ) {
	    log.info( "BuryDataService filtered: [{}]-[{}]", data.getRequestMethod(), data.getPath() );
	    return;
	}

	String reqPath = data.getPath().substring( 1 );
	List<String> paths = Arrays.asList( reqPath.split( "/" ) );

	BuryData item = new BuryData();
	BeanUtil.copyProperties( data, item );
	item.setPaths( paths );

	dao.create( item );

	log.info( "BuryDataService create: {}", item );
    }

}
