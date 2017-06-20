package cn.zxf.data_bury_point.stats;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.stereotype.Component;

import cn.zxf.data_bury_point.bury.BuryData;
import cn.zxf.data_bury_point.stats.so.UserVisitSo;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class StatsMongoDao {

    @Autowired
    private MongoTemplate oper;

    public List<UserVisitSo> userVisitStats() {
	Aggregation agg = Aggregation.newAggregation( //
	        Aggregation.group( BuryData.FIELD_USER_ID )//
	                .first( BuryData.FIELD_USER_ID ).as( UserVisitSo.FIELD_USER_ID )//
	                .count().as( UserVisitSo.FIELD_COUNT )//
	);
	log.info( "agg: {}", agg.toString() );
	List<UserVisitSo> results = oper.aggregate( agg, BuryData.class, UserVisitSo.class ).getMappedResults();
	return results;
    }

}
