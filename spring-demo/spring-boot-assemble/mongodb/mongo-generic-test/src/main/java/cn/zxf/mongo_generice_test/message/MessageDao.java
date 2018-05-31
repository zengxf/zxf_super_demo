package cn.zxf.mongo_generice_test.message;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

@Component
public class MessageDao {

    @Autowired
    private MongoTemplate temp;

    public void insert( Message msg ) {
        temp.insert( msg );
    }

    public List<Message> findAll() {
        return temp.findAll( Message.class );
    }

    public void clear() {
        temp.remove( Query.query( new Criteria() ), Message.class );
    }

}
