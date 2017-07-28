package cn.zxf.unit_test.position;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class PositionMongoDao {

    @Autowired
    private MongoTemplate mongo;

    public Position insert( Position position ) {
	mongo.insert( position );
	return position;
    }

    public void save( Position position ) {
	log.info( "\nposition dao save: {}\n", position );
	mongo.save( position );
    }

    public List<Position> findAll() {
	List<Position> all = mongo.findAll( Position.class );
	return all;
    }

}
