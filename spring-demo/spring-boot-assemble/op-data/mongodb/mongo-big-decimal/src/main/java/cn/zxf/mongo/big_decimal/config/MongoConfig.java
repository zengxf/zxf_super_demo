package cn.zxf.mongo.big_decimal.config;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.CustomConversions;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;

@Configuration
@EnableMongoAuditing
public class MongoConfig {

    @Autowired
    private MongoTemplate tmpl;

    @PostConstruct
    public void setCustomConversions() {
        List<Converter<?, ?>> converters = Arrays.asList( //
                new DoubleToBigDecimalConverter(), //
                new BigDecimalToDoubleConverter() //
        );
        CustomConversions cc = new CustomConversions( converters );
        MappingMongoConverter mongoMapping = (MappingMongoConverter) tmpl.getConverter();
        mongoMapping.setCustomConversions( cc ); // tell mongo to use the custom converters
        mongoMapping.afterPropertiesSet();
    }

    public static class BigDecimalToDoubleConverter implements Converter<BigDecimal, Double> {
        @Override
        public Double convert( BigDecimal source ) {
            return source.doubleValue();
        }
    }

    public class DoubleToBigDecimalConverter implements Converter<Double, BigDecimal> {
        @Override
        public BigDecimal convert( Double source ) {
            return BigDecimal.valueOf( source );
        }
    }

}
