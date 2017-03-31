package cn.zxf.spring.boot.data.cache.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.zxf.spring.boot.data.cache.demo.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
	

}
