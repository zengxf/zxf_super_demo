package cn.zxf.data_bury_point.bury;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

/**
 * 埋点数据 Dao
 * 
 * <p>
 * Created by zxf on 2017-06-01
 */
@Component
public class BuryDataMongoDao {

    @Autowired
    private MongoTemplate mongo;

    /**
     * 创建埋点
     * 
     * @param item
     */
    public void create( BuryData item ) {
	mongo.insert( item );
    }

}
