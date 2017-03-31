package cn.zxf.spring.boot.mvc.batch.demo.batch;

import org.springframework.batch.item.validator.ValidatingItemProcessor;
import org.springframework.batch.item.validator.ValidationException;

import cn.zxf.spring.boot.mvc.batch.demo.domain.Person;

public class CsvItemProcessor extends ValidatingItemProcessor<Person> {

    @Override
    public Person process( Person item ) throws ValidationException {
	super.process( item ); // 1

	if ( item.getNation().equals( "汉族" ) ) { // 2
	    item.setNation( "01" );
	} else {
	    item.setNation( "02" );
	}
	return item;
    }

}
