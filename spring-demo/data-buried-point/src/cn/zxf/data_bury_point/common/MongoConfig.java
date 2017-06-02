package cn.zxf.data_bury_point.common;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

@Configuration
@EnableMongoRepositories
@EnableMongoAuditing
public class MongoConfig {

    @Value( "${mongodb.database}" )
    private String dbName;

    @Value( "${mongodb.list}" )
    private String addr;

    @Bean
    public MongoDbFactory mongoDbFactory() throws Exception {
	String[] addrList = addr.split( "," );
	List<ServerAddress> list = new ArrayList<>();
	for ( String str : addrList ) {
	    String[] serverAddress = str.split( ":" );
	    list.add( new ServerAddress( serverAddress[0], Integer.valueOf( serverAddress[1] ) ) );
	}
	return new SimpleMongoDbFactory( new MongoClient( list ), dbName );
    }

    @Bean
    public MongoTemplate mongoOperations() throws Exception {
	return new MongoTemplate( mongoDbFactory() );
    }

}
