package cn.zxf.spring.boot.mvc.junit.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.zxf.spring.boot.mvc.junit.demo.dao.PersonRepository;
import cn.zxf.spring.boot.mvc.junit.demo.domain.Person;

@RestController
@RequestMapping( "/person" )
public class PersonController {
    @Autowired
    PersonRepository personRepository;

    @RequestMapping( method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE } )
    public List<Person> findAll() {
	return personRepository.findAll();
    }

}
