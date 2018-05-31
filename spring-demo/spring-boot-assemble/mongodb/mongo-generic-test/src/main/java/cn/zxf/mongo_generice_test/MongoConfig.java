package cn.zxf.mongo_generice_test;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.CustomConversions;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;

import com.mongodb.DBObject;

import cn.zxf.mongo_generice_test.message.IAttach;
import cn.zxf.mongo_generice_test.message.attach.UserAttach;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableMongoAuditing
public class MongoConfig {

    // @Bean
    public DefaultMongoTypeMapper typeMapper( MongoTemplate template ) {
        DefaultMongoTypeMapper mapper = new DefaultMongoTypeMapper( null );
        ( (MappingMongoConverter) template.getConverter() ).setTypeMapper( mapper );
        this.setCustomConversions( template );
        return mapper;
    }

    private void setCustomConversions( MongoTemplate template ) {
        List<Converter<?, ?>> converters = Arrays.asList( new BsonToAttachConverter() );
        CustomConversions cc = new CustomConversions( converters );
        MappingMongoConverter mongoMapping = (MappingMongoConverter) template.getConverter();
        mongoMapping.setCustomConversions( cc );
        mongoMapping.afterPropertiesSet();
    }

    public static class BsonToAttachConverter implements Converter<DBObject, IAttach> {
        @Override
        public IAttach convert( DBObject bson ) {
            if ( bson == null )
                return null;

            log.info( "==================== Bson To Attach ===================" );

            IAttach attach = UserAttach.builder()
                    .build();
            return attach;
        }
    }

}
