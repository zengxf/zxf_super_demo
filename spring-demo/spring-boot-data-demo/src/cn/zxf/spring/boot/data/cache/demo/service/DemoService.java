package cn.zxf.spring.boot.data.cache.demo.service;

import cn.zxf.spring.boot.data.cache.demo.domain.Person;

public interface DemoService {
	public Person save(Person person);
	
	public void remove(Long id);
	
	public Person findOne(Person person);

}
