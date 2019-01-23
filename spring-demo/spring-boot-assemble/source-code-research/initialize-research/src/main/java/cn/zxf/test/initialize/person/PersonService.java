package cn.zxf.test.initialize.person;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class PersonService {

    @Autowired
    @Qualifier( "person1" )
    private Person person1;
    
    @Autowired
    private PersonDao dao;

    @PostConstruct
    public void init() {
        log.info( "\n person1: {} \n", this.person1 );
        dao.testInsert();
    }

}
